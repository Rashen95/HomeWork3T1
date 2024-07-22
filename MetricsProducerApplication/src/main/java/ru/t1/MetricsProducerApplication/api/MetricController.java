package ru.t1.MetricsProducerApplication.api;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.t1.MetricsProducerApplication.dto.MetricDTO;
import ru.t1.MetricsProducerApplication.service.MetricSendService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/metrics")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MetricController {
    MetricSendService metricSendService;

    @PostMapping
    public void postMetric(@RequestBody MetricDTO metric) {
        metricSendService.sendMetric(metric);
    }
}