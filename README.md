# flume-custom-components

## Requirements
| Component |   Version   |
| :-------: | :---------: |
|    JDK    |	  1.8     |


## Custom Source
### ClouderaManagerImpalaQuery Source

Fetch impala query information from cloudera manager by http protocol. Fetch the impala query information of last hour per hour. Required properties are in **bold**.

| PropertyName |    Default   | Description  |
| :----------: | :----------: | :----------: |
|   channels   |	   –      |              |	 
|   **type**   |       –      |	The component type name, needs to be com.simba.flume.source.query.ClouderaManagerImpalaQuerySource |
|  **cmHost**  |       –	  | The DNS or IP of ClouderaManager |
|    cmPort    |       80	  | The port of ClouderaManager |
| cmEnableTLS  |     false	  | Whether ClouderaManager enable TLS |
|  cmUsername  |       –	  | The username of ClouderaManager |
|  cmPassword  |       –	  | The password of ClouderaManager |
|cmClusterName |    cluster	  | The cluster name of ClouderaManager |
|cmServiceName |     impala	  | The impala service name of ClouderaManager |


## Usage




