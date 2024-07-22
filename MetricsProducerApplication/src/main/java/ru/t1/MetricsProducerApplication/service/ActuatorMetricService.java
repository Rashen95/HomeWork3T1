package ru.t1.MetricsProducerApplication.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.t1.MetricsProducerApplication.dto.MetricDTO;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ActuatorMetricService {
    MetricsEndpoint metricsEndpoint;
    MetricSendService metricSendService;
    private final static int ONCE_PER_MINUTE = 60000;
    private final static String[] metricsNames = {"jvm.memory.used", "system.cpu.usage"};

    @Scheduled(fixedRate = ONCE_PER_MINUTE)
    public void sendMetrics() {
        for (String metricName : metricsNames) {
            MetricDTO mDTO = MetricDTO.builder()
                    .metricName(metricName)
                    .metricValue(metricsEndpoint.metric(metricName, null)
                            .getMeasurements()
                            .get(0)
                            .getValue()
                            .toString())
                    .timestamp(LocalDateTime.now())
                    .build();
            metricSendService.sendMetric(mDTO);
            log.info("Metric {} sent", mDTO.getMetricName());
        }
    }
}