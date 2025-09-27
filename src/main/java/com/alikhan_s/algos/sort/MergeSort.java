package com.alikhan_s.algos.sort;

import java.util.Arrays;

public class MergeSort {
    private static final int CUTOFF = 16; // small-n cutoff for insertion sort
    private final int[] buffer;

    public MergeSort(int n) {
        this.buffer = new int[n]; // reusable buffer
    }

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right) {
        if (right - left <= CUTOFF) {
            insertionSort(arr, left, right);
            return;
        }

        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        // copy to buffer
        System.arraycopy(arr, left, buffer, left, right - left + 1);

        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (buffer[i] <= buffer[j]) {
                arr[k++] = buffer[i++];
            } else {
                arr[k++] = buffer[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = buffer[i++];
        }
        while (j <= right) {
            arr[k++] = buffer[j++];
        }
    }

    private void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
