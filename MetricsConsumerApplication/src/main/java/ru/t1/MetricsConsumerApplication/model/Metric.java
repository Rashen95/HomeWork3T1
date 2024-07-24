package ru.t1.MetricsConsumerApplication.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "metrics", schema = "my_schema")
public class Metric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "metricName")
    String metricName;

    @Column(name = "metricValue")
    String metricValue;

    @Column(name = "metric_creation_time")
    LocalDateTime metricCreationTime;
}