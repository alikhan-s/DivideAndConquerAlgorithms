package com.alikhan_s.algos.metrics;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    private final String fileName;

    public CsvWriter(String fileName) {
        this.fileName = fileName;
    }

    public void writeHeader() throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("algorithm,n,comparisons,allocations,maxDepth,timeNs\n");
        }
    }

    public void appendRow(String algorithm, int n, Metrics m, long timeNs) throws IOException {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(String.format("%s,%d,%d,%d,%d,%d\n",
                    algorithm, n, m.getComparisons(), m.getAllocations(), m.getMaxDepth(), timeNs));
        }
    }
}
