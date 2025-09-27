package com.alikhan_s.algos.sort;

import java.util.Random;

public class QuickSort {
    private final Random random = new Random();

    public void sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private void quicksort(int[] arr, int left, int right) {
        while (left < right) {
            // Randomized pivot
            int pivotIndex = left + random.nextInt(right - left + 1);
            int pivotNewIndex = partition(arr, left, right, pivotIndex);

            // Sizes of partitions
            int leftSize = pivotNewIndex - left;
            int rightSize = right - pivotNewIndex;

            // Recurse on smaller partition first (bounded stack depth)
            if (leftSize < rightSize) {
                quicksort(arr, left, pivotNewIndex - 1);
                left = pivotNewIndex + 1; // iterate on larger side
            } else {
                quicksort(arr, pivotNewIndex + 1, right);
                right = pivotNewIndex - 1; // iterate on larger side
            }
        }
    }

    private int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
