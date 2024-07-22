package ru.t1.MetricsProducerApplication.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MetricDTO {
    String metricName;
    String metricValue;
    LocalDateTime timestamp;
}