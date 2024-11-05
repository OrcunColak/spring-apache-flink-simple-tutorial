# Read Me

The original idea is from  
https://medium.com/@mahammadkhalilov/integrating-apache-flink-with-spring-boot-a-comprehensive-guide-c52d59116aef

# Docker

docker is from  
https://medium.com/marionete/how-to-set-up-a-local-flink-cluster-using-docker-0a0a741504f6

# Sql Client

Go to JobManager
Run

```
./bin/sql-client.sh
```

Run

```
-- Create source table to read from Kafka
CREATE TABLE source_table (
`field1` STRING,
`field2` STRING
) WITH (
'connector' = 'kafka',
'topic' = 'input-topic',
'properties.bootstrap.servers' = 'kafka:9093',
'properties.group.id' = 'my-group',
'scan.startup.mode' = 'earliest-offset',
'format' = 'json'
);

-- Create sink table to write to Kafka
CREATE TABLE sink_table (
`field1` STRING,
`field2` STRING
) WITH (
'connector' = 'kafka',
'topic' = 'output-topic',
'properties.bootstrap.servers' = 'kafka:9093',
'format' = 'json'
);

-- Define the SQL query to process the data
INSERT INTO sink_table
SELECT field1, field2
FROM source_table
WHERE field2 = 'correct';
```