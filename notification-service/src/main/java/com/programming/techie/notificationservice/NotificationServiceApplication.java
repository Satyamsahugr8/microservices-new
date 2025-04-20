package com.programming.techie.notificationservice;


import com.programming.techie.notificationservice.event.OrderPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @KafkaListener(topics = "notificationTopic", groupId = "notificationGroup")
    public void listen(OrderPlacedEvent orderPlacedEvent) {
        log.info("Received message: " + orderPlacedEvent);
        // Process the message
        // send a mail notification
    }

}