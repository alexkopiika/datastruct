package io.samples.datastruct.heap;

public class HeapSort {
    public static void sort(Object[] input) {
        // build max heap
        for (int i = (input.length - 1) / 2; i >= 0; i--) {
            maxHeapify(input, input.length, i);
        }

        for (int i = input.length - 1; i > 0; i--) {
            exchange(input, 0, i);
            maxHeapify(input, i, 0);
        }
    }

    private static void maxHeapify(Object[] a, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && compare(a, left, i) > 0) {
            largest = left;
        }
        if (right < n && compare(a, right, largest) > 0) {
            largest = right;
        }
        if (largest != i) {
            exchange(a, i, largest);
            maxHeapify(a, n, largest);
        }
    }

    private static int compare(Object[] a, int i, int j) {
        return ((Comparable) a[i]).compareTo(a[j]);
    }

    private static void exchange(Object[] a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
