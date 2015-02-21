package com.y62wang.learn.utils;


import java.util.ArrayList;
import java.util.List;

public class BatchInputGenerator<T> {
    private final InputGenerator<T> generator;

    public BatchInputGenerator(final InputGenerator<T> generator) {
        this.generator = generator;
    }

    public List<T> generateBatch(final int batchSize) {
        final List<T> batch = new ArrayList<T>();
        for (int i = 0; i < batchSize; i++) {
            batch.add(generator.next());
        }
        return batch;
    }
}
