package io.samples.datastruct.heap;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxBinaryHeapTest {
    @Test
    public void testBuildFromArray() throws Exception {
        Integer[] input = new Integer[] {3, 2, 5, 4, 1, 2, 6};
        MaxBinaryHeap<Integer> h = new MaxBinaryHeap<>();
        h.buildMaxHeap(input);

        assertThat(h.toArray()).containsExactly(expectedHeap(input));
    }

    private <T> T[] expectedHeap(T[] input) {
        PriorityQueue<T> q = new PriorityQueue<>((Comparator<T>) Comparator.reverseOrder());
        for (T e: input) {
            q.add(e);
        }

        Object[] result = new Object[q.size()];
        return (T[]) q.toArray(result);
    }
}
