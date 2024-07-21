package ru.t1.MetricsProducerApplication.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic metricTopic() {
        return new NewTopic("metrics-topic", 1, (short) 1);
    }
}