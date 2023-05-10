package com.alexsh.kafkaproducer.initsend;

import com.alexsh.kafkaproducer.kafkasender.KafkaSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InitSend {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaSender kafkaSender;

    @Value("${application.kafka.topic}")
    private String messagesTopic;

    @EventListener
    void initiateSendingMessage(ApplicationReadyEvent event) {
        LOG.info("---------------------------------");
        kafkaSender.sendMessage("I'll be recevied by MultipleTopicListener, Listener & ClassLevel KafkaHandler", messagesTopic);
    }
}