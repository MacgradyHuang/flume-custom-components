package com.simba.flume.source;

import org.apache.flume.Context;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.PollableSource;
import org.apache.flume.conf.Configurable;
import org.apache.flume.event.EventBuilder;
import org.apache.flume.source.AbstractSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Random;

public class CustomPollableSource extends AbstractSource implements Configurable, PollableSource {

    private static final Logger logger = LoggerFactory.getLogger(CustomPollableSource.class);

    @Override
    public void configure(Context context) {

    }

    @Override
    public PollableSource.Status process() throws EventDeliveryException {
        PollableSource.Status status = Status.BACKOFF;
        try {
            Random random = new Random();
            int randomNum = random.nextInt(100);
            String text = "Hello World1 :" + random.nextInt(100);  //实际需要传的内容
            HashMap<String, String> header = new HashMap<>();
            header.put("id", Integer.toString(randomNum));   //将id--value放入到header中
            this.getChannelProcessor().processEvent(EventBuilder.withBody(text, Charset.forName("UTF-8"), header)); //prcessEvent()将数据传上去

            status = Status.READY;
        } catch (Exception e) {
            logger.error("process exception", e);
            status = Status.BACKOFF;
        }

        return status;
    }

    @Override
    public long getBackOffSleepIncrement() {
        //在process方法返回Status.BACKOFF时补偿暂停线程处理，等待超时时间之后重试
        return 1000;
    }

    @Override
    public long getMaxBackOffSleepInterval() {
        //在process方法返回Status.BACKOFF时补偿暂停线程处理，等待超时时间之后重试
        return 10000;
    }
}
