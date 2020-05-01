# Producing and Consuming Services using Kafka

This tutorial covers how to use Spring Boot with Spring Kafka to Publish JSON/String message to a Kafka topic.
## Installing Kafka 
- Download and unzip the binary release of Apached Kafka.
	- https://kafka.apache.org/
## Setting Server Port 
- Inside the config folder(kafka_2.11-2.3.1/config). 
	- Note the path would be different depends on the version number.
	- Edit the server.properties file and uncomment the following command: 
		- listeners=PLAINTEXT://:9096
		- Set the port number you like, it would be used to communicate with Kafka  

## Start Zookeeper
- `Run the following command to start Zookeeper: 
	- bin/zookeeper-server-start.sh config/zookeeper.properties`

## Start Kafka Server
- `Run the following command to start the server
	- bin/kafka-server-start.sh config/server.properties`

## Create Kafka Topic
- `bin/kafka-topics.sh --create --zookeeper localhost:2182 --replication-factor 1 --partitions 1 --topic Kafka_Example`

## Consume from the Kafka Topic, we will use  the terminal to monitor the consumed services
- `bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic Kafka_POC --from-beginning`

## To test the webservice, invoke the webService using input messages
- `http://localhost:8081/kafka/publish/id`
- `http://localhost:8081/kafka/publish/100`
