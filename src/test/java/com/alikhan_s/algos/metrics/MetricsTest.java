package com.alikhan_s.algos.metrics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MetricsTest {

    @Test
    void testComparisonsAndAllocations() {
        Metrics m = new Metrics();
        m.incComparisons();
        m.incComparisons();
        m.incAllocations();
        assertEquals(2, m.getComparisons());
        assertEquals(1, m.getAllocations());
    }

    @Test
    void testRecursionDepth() {
        Metrics m = new Metrics();
        m.enterRecursion(); // depth = 1
        m.enterRecursion(); // depth = 2
        m.exitRecursion();  // depth = 1
        assertEquals(2, m.getMaxDepth());
    }
}
