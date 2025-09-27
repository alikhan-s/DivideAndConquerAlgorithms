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
    void testPartitionBasic() {
        int[] arr = {3, 2, 1, 5, 4};
        int pivotIndex = 2; // arr[2] = 1
        int newPivot = ArrayUtils.partition(arr, 0, arr.length - 1, pivotIndex);

        // Проверяем: всё слева <= pivot, всё справа >= pivot
        for (int i = 0; i < newPivot; i++) {
            assertTrue(arr[i] <= arr[newPivot]);
        }
        for (int i = newPivot + 1; i < arr.length; i++) {
            assertTrue(arr[i] >= arr[newPivot]);
        }
    }

    @Test
    void testPartitionDifferentPivot() {
        int[] arr = {9, 3, 7, 1, 5};
        int pivotIndex = 0; // arr[0] = 9
        int newPivot = ArrayUtils.partition(arr, 0, arr.length - 1, pivotIndex);

        for (int i = 0; i < newPivot; i++) {
            assertTrue(arr[i] <= arr[newPivot]);
        }
        for (int i = newPivot + 1; i < arr.length; i++) {
            assertTrue(arr[i] >= arr[newPivot]);
        }
    }

    @Test
    void testShuffleKeepsElements() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] copy = arr.clone();
        ArrayUtils.shuffle(arr);

        // Содержимое то же самое, просто порядок изменился
        assertEquals(copy.length, arr.length);
        assertEquals(5, arr.length);
        assertTrue(java.util.Arrays.stream(arr).allMatch(x -> java.util.Arrays.stream(copy).anyMatch(y -> y == x)));
    }

    @Test
    void testGuardIndex() {
        int[] arr = {10, 20, 30};
        assertDoesNotThrow(() -> ArrayUtils.guardIndex(arr, 0));
        assertDoesNotThrow(() -> ArrayUtils.guardIndex(arr, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.guardIndex(arr, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.guardIndex(arr, 3));
    }
}
