package com.alexsh.kafka.kafkalisteners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    Logger LOG = LoggerFactory.getLogger(KafkaListeners.class);

    @KafkaListener(topics = "messages", groupId = "default")
    void listener(String data) {
        LOG.info("Listener received: " + data);
    }
}