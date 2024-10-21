package com.colak.springtutorial.config;

import lombok.RequiredArgsConstructor;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FlinkJobManager {

    private final StreamExecutionEnvironment env;

    public void start() throws Exception {

        // Create an in-memory source (a list of strings)
        List<String> inputData = new ArrayList<>();
        inputData.add("flink");
        inputData.add("streaming");
        inputData.add("example");

        // Create a DataStream from the in-memory source
        DataStream<String> sourceStream = env.fromData(inputData);

        // Transform the data (convert strings to uppercase)
        DataStream<String> transformedStream = sourceStream
                .map((MapFunction<String, String>) String::toUpperCase);

        // Print the transformed stream directly to the console
        transformedStream.print();  // This adds an operator to the topology

        // Execute the Flink job
        env.execute("In-Memory Flink Job");
    }

}
