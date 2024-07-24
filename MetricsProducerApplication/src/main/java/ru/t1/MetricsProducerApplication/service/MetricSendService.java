package ru.t1.MetricsProducerApplication.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.t1.MetricsProducerApplication.dto.MetricDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class MetricSendService {
    private final KafkaTemplate<String, Map<String, String>> kafkaTemplate;

    public void sendMetric(Map<String, String> metric) {
        kafkaTemplate.send("metrics-topic", metric);
        sendLog(metric);
    }

    public void sendMetric(MetricDTO metricDTO) {
        Map<String, String> metric = new HashMap<>();
        metric.put("metricName", metricDTO.getMetricName());
        metric.put("metricValue", metricDTO.getMetricValue());
        metric.put("metricCreationTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        kafkaTemplate.send("metrics-topic", metric);
        sendLog(metric);
    }

    public void sendLog(Map<String, String> metric) {
        log.info("Metric {} send", metric.get("metricName"));
    }
}