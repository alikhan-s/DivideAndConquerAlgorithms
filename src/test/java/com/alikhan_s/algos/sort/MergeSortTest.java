package com.alikhan_s.algos.sort;

import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest {

    @Test
    void testSmallArray() {
        int[] arr = {5, 2, 4, 6, 1, 3};
        int[] expected = arr.clone();
        java.util.Arrays.sort(expected);

        MergeSort sorter = new MergeSort(arr.length);
        sorter.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testLargeRandomArray() {
        Random random = new Random();
        int n = 1000;
        int[] arr = random.ints(n, -10000, 10000).toArray();
        int[] expected = arr.clone();
        java.util.Arrays.sort(expected);

        MergeSort sorter = new MergeSort(arr.length);
        sorter.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = arr.clone();

        MergeSort sorter = new MergeSort(arr.length);
        sorter.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        int[] expected = {42};

        MergeSort sorter = new MergeSort(arr.length);
        sorter.sort(arr);

        assertArrayEquals(expected, arr);
    }
}
