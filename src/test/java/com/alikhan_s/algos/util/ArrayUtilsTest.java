package com.alikhan_s.algos.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

    @Test
    void testSwap() {
        int[] arr = {1, 2, 3};
        ArrayUtils.swap(arr, 0, 2);
        assertArrayEquals(new int[]{3, 2, 1}, arr);
    }

    @Test
    void testPartition() {
        int[] arr = {3, 2, 1, 5, 4};
        int pivotIndex = ArrayUtils.partition(arr, 0, arr.length - 1);
        for (int i = 0; i < pivotIndex; i++) {
            assertTrue(arr[i] <= arr[pivotIndex]);
        }
        for (int i = pivotIndex + 1; i < arr.length; i++) {
            assertTrue(arr[i] >= arr[pivotIndex]);
        }
    }

    @Test
    void testShuffle() {
        int[] arr = {1, 2, 3, 4, 5};
        ArrayUtils.shuffle(arr);
        assertEquals(5, arr.length);
    }

    @Test
    void testGuardIndex() {
        int[] arr = {1, 2, 3};
        assertDoesNotThrow(() -> ArrayUtils.guardIndex(arr, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.guardIndex(arr, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.guardIndex(arr, 3));
    }
}
