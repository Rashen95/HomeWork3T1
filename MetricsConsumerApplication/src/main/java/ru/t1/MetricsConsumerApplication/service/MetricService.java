package ru.t1.MetricsConsumerApplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.t1.MetricsConsumerApplication.model.Metric;
import ru.t1.MetricsConsumerApplication.repository.MetricsRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MetricService {
    private final MetricsRepository metricsRepository;

    public void save(Map<String, String> metric) {
        metricsRepository.save(Metric.builder()
                .metricName(metric.get("metricName"))
                .metricValue(metric.get("metricValue"))
                .metricCreationTime(
                        LocalDateTime.parse(
                                metric.get("metricCreationTime"),
                                DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
                        )
                )
                .build());
    }

    public List<Metric> findAll() {
        return metricsRepository.findAll();
    }

    public Optional<Metric> findById(Long id) {
        return metricsRepository.findById(id);
    }
}