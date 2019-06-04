package com.simba.flume.source;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.flume.ChannelException;
import org.apache.flume.Context;
import org.apache.flume.EventDrivenSource;
import org.apache.flume.conf.Configurable;
import org.apache.flume.event.EventBuilder;
import org.apache.flume.source.AbstractSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class CustomEventDrivenSource extends AbstractSource implements Configurable, EventDrivenSource {

    private static final Logger logger = LoggerFactory.getLogger(CustomEventDrivenSource.class);
    private AtomicBoolean threadShouldStop;
    private Thread thread;
    private ExecutorService handlerService;

    public CustomEventDrivenSource() {
        super();
        
        this.threadShouldStop = new AtomicBoolean(false);
    }

    @Override
    public void configure(Context context) {

    }

    @Override
    public synchronized void start() {
        logger.info("Source starting");

        this.handlerService = Executors.newCachedThreadPool((new ThreadFactoryBuilder()).setNameFormat("custom-event-driver-source-handler-%d").build());
        TaskContext context = new TaskContext();
        this.threadShouldStop.set(false);
        context.handlerService = this.handlerService;
        context.source = this;
        context.shouldStop = this.threadShouldStop;
        this.thread = new Thread(context);
        this.thread.start();
        logger.debug("Source started");

        super.start();
    }

    @Override
    public synchronized void stop() {
        logger.info("Source stopping");

        this.threadShouldStop.set(true);
        if (this.thread != null) {
            logger.debug("Stopping handler thread");

            while(this.thread.isAlive()) {
                try {
                    logger.debug("Waiting for handler to finish");
                    this.thread.interrupt();
                    this.thread.join(500L);
                } catch (InterruptedException var4) {
                    logger.debug("Interrupted while waiting for handler to finish");
                    Thread.currentThread().interrupt();
                }
            }

            logger.debug("Stopped handler thread");
        }

        if (this.handlerService != null) {
            this.handlerService.shutdown();
            logger.debug("Waiting for handler service to stop");

            try {
                this.handlerService.awaitTermination(500L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException var2) {
                logger.debug("Interrupted while waiting for handler service to stop");
                Thread.currentThread().interrupt();
            }

            if (!this.handlerService.isShutdown()) {
                this.handlerService.shutdownNow();
            }

            logger.debug("Handler service stopped");
        }

        logger.debug("Source stopped");

        super.stop();
    }

    private static class CustomTaskHandler implements Runnable {
        private EventDrivenSource source;

        @Override
        public void run() {
            // do custom task handle
            try {
                Random random = new Random();
                int randomNum = random.nextInt(100);
                String text = "Hello World2 :" + random.nextInt(100);  //实际需要传的内容
                HashMap<String, String> header = new HashMap<>();
                header.put("id", Integer.toString(randomNum));   //将id--value放入到header中
                this.source.getChannelProcessor().processEvent(EventBuilder.withBody(text, Charset.forName("UTF-8"), header));//prcessEvent()将数据传上去
            } catch (ChannelException e) {
                CustomEventDrivenSource.logger.debug("channel exception", e);
            }
        }
    }

    private static class TaskContext implements Runnable {
        private ExecutorService handlerService;
        private EventDrivenSource source;
        private AtomicBoolean shouldStop;

        @Override
        public void run() {
            CustomEventDrivenSource.logger.debug("Starting accept handler");

            while(!this.shouldStop.get()) {
                try {
                    CustomTaskHandler task = new CustomTaskHandler();
                    task.source = this.source;

                    this.handlerService.submit(task);

                    Thread.sleep(60000);
                } catch (Exception e) {
                    CustomEventDrivenSource.logger.error("Unable to handle data. Exception follows.", e);
                }
            }

            CustomEventDrivenSource.logger.debug("Accept handler exiting");
        }
    }
}
