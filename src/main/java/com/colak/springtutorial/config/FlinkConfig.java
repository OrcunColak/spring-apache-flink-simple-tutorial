package com.colak.springtutorial.config;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlinkConfig {

    @Bean
    public StreamExecutionEnvironment streamExecutionEnvironment() {
        return StreamExecutionEnvironment.getExecutionEnvironment();
    }

    @Bean
    CommandLineRunner commandLineRunner(FlinkJobManager flinkJobManager) {
        return _ -> flinkJobManager.start();
    }
}
