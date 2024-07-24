package ru.t1.MetricsConsumerApplication.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

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
    String id;

    @Column(name = "metricName")
    String metricName;

    @Column(name = "metricValue")
    String metricValue;

    @Column(name = "timestamp_date")
    LocalDate timestampDate;
}