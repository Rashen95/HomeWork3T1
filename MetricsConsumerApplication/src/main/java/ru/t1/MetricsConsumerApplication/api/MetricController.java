package ru.t1.MetricsConsumerApplication.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.t1.MetricsConsumerApplication.model.Metric;
import ru.t1.MetricsConsumerApplication.service.MetricService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/metrics")
public class MetricController {
    private final MetricService metricService;

    @GetMapping
    public List<Metric> getMetrics() {
        return metricService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Metric> getMetric(@PathVariable Long id) {
        Optional<Metric> metric = metricService.findById(id);
        return metric.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}