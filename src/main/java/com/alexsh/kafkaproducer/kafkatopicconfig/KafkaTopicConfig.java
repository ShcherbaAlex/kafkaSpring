package com.alexsh.kafkaproducer.kafkatopicconfig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Value("${application.kafka.topic}")
    private String messagesTopic;

    @Bean
    NewTopic messagesTopic() {
        return TopicBuilder.name(messagesTopic).build();
    }
}
