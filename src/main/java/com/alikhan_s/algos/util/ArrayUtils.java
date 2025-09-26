package com.alikhan_s.algos.util;

import java.util.Random;

public class ArrayUtils {

    private static final Random RAND = new Random();

    // Swap two elements in array
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // Partition (Lomuto scheme for simplicity)
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    // Fisher-Yates shuffle
    public static void shuffle(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = RAND.nextInt(i + 1);
            swap(arr, i, j);
        }
    }

    // Guard for debugging index
    public static void guardIndex(int[] arr, int i) {
        if (i < 0 || i >= arr.length) {
            throw new IndexOutOfBoundsException("Index " + i + " out of bounds for length " + arr.length);
        }
    }
}
