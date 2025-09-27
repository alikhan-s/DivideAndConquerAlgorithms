package com.alikhan_s.algos.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortTest {

    @Test
    void testSmallArray() {
        int[] arr = {5, 2, 4, 6, 1, 3};
        int[] expected = arr.clone();
        Arrays.sort(expected);

        QuickSort sorter = new QuickSort();
        sorter.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testLargeRandomArray() {
        Random random = new Random();
        int n = 1000;
        int[] arr = random.ints(n, -10000, 10000).toArray();
        int[] expected = arr.clone();
        Arrays.sort(expected);

        QuickSort sorter = new QuickSort();
        sorter.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = arr.clone();

        QuickSort sorter = new QuickSort();
        sorter.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testReverseSorted() {
        int[] arr = {9, 7, 5, 3, 1};
        int[] expected = arr.clone();
        Arrays.sort(expected);

        QuickSort sorter = new QuickSort();
        sorter.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testDuplicates() {
        int[] arr = {5, 3, 3, 3, 2, 2, 1};
        int[] expected = arr.clone();
        Arrays.sort(expected);

        QuickSort sorter = new QuickSort();
        sorter.sort(arr);

        assertArrayEquals(expected, arr);
    }
}
