package com.techprimers.kafka.springbootkafkaproducerexample.resource;

import com.techprimers.kafka.springbootkafkaproducerexample.model.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class LogicResource {

    @Autowired
    private KafkaTemplate<String, BusinessLogic> kafkaTemplate;

    private static final String TOPIC = "Kafka_POC";

    @GetMapping("/publish/{id}")
    public String post(@PathVariable("id") final String id) {

        kafkaTemplate.send(TOPIC, new BusinessLogic(id, "default", "default"));

        return "Request has been submitted successfully!";
    }
}
