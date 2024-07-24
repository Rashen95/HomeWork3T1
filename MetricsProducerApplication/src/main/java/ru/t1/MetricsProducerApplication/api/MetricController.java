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
public class MetricController {
    private final MetricSendService metricSendService;

    @PostMapping
    public void postMetric(@RequestBody MetricDTO metricDTO) {
        metricSendService.sendMetric(metricDTO);
    }
}