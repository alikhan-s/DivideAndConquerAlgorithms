package com.alikhan_s.algos;

import com.alikhan_s.algos.metrics.Metrics;
import com.alikhan_s.algos.metrics.CsvWriter;

public class App {
    public static void main(String[] args) throws Exception {
        Metrics m = new Metrics();
        m.incComparisons();
        m.incAllocations();
        m.enterRecursion();
        m.exitRecursion();

        CsvWriter writer = new CsvWriter("metrics.csv");
        writer.writeHeader();
        writer.appendRow("demo", 10, m, 12345);

        System.out.println("Metrics written to metrics.csv");
    }
}

