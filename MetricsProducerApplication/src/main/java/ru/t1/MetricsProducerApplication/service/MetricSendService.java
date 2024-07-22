package ru.t1.MetricsProducerApplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.t1.MetricsProducerApplication.dto.MetricDTO;

@Service
@RequiredArgsConstructor
public class MetricSendService {
    private final KafkaTemplate<String, MetricDTO> kafkaTemplate;

    public void sendMetric(MetricDTO metricDTO) {
        kafkaTemplate.send("metrics-topic", metricDTO);
    }
}