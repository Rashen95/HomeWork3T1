package ru.t1.MetricsConsumerApplication.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class MetricListenService {
    private final MetricService metricService;

    @KafkaListener(topics = "metrics-topic", groupId = "group1",
            containerFactory = "userKafkaListenerContainerFactory")
    void listenerWithMessageConverter(Map<String, String> metric) {
        metricService.save(metric);
    }
}