package ru.t1.MetricsProducerApplication.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActuatorMetricService {
    private final MetricsEndpoint metricsEndpoint;
    private final MetricSendService metricSendService;
    private final static int ONCE_PER_MINUTE = 60_000;
    private final static String[] metricsNames = {"jvm.memory.used", "system.cpu.usage"};

    @Scheduled(fixedRate = ONCE_PER_MINUTE)
    public void sendMetrics() {
        for (String metricName : metricsNames) {
            Map<String, String> metric = new HashMap<>();
            metric.put("metricName", metricName);
            metric.put("metricValue", metricsEndpoint.metric(metricName, null)
                    .getMeasurements()
                    .get(0)
                    .getValue()
                    .toString());
            metric.put("metricCreationTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
            metricSendService.sendMetric(metric);
        }
    }
}