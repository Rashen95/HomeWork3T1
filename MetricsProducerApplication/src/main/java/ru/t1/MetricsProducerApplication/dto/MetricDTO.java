package ru.t1.MetricsProducerApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetricDTO {
    String metricName;
    String metricValue;
}