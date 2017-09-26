package io.samples.datastruct.heap;

import java.util.Arrays;

public class MaxBinaryHeap<K extends Comparable<K>> {
    private Object[] elements;

    private int size;

    public MaxBinaryHeap() {

    }

    public void buildMaxHeap(Object[] input) {
        this.elements = Arrays.copyOf(input, input.length);
        this.size = elements.length;

        int lastParent = (size - 1) / 2;
        for (int i = lastParent; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public K[] toArray() {
        return (K[]) elements;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    private void maxHeapify(int i) {
        int largest = i;
        int left = left(i);
        int right = right(i);
        if (left < size && compare(left, i) > 0) {
            largest = left;
        }
        if (right < size && compare(right, largest) > 0) {
            largest = right;
        }
        if (largest != i) {
            exchange(i, largest);
            maxHeapify(largest);
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int compare(int i, int j) {
        return ((K) elements[i]).compareTo((K) elements[j]);
    }

    private void exchange(int i, int j) {
        Object tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }
}
