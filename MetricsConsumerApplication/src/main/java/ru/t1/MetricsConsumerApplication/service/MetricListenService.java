package ru.t1.MetricsConsumerApplication.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class MetricListenService {
    @KafkaListener(topics = "metrics-topic", groupId = "group1",
            containerFactory = "userKafkaListenerContainerFactory")
    void listenerWithMessageConverter(Map<String, String> metric) {
        log.info("Metric received: {}", metric);
    }
}