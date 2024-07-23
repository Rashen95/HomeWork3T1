package ru.t1.MetricsProducerApplication.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class MetricSendService {
    private final KafkaTemplate<String, Map<String, String>> kafkaTemplate;

    public void sendMetric(Map<String, String> metric) {
        kafkaTemplate.send("metrics-topic", metric);
        log.info("Metric {} sent", metric);
    }
}