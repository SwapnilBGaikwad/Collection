package com.datastructures;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HeapTest {
    @Test
    public void add_heap() throws Exception {
        Heap<Integer> heap = new Heap<>(10);
        assertTrue(heap.add(4));
        assertTrue(heap.add(2));
        assertTrue(heap.add(3));
        assertTrue(heap.add(1));

        System.out.println(heap);

        Assert.assertEquals(new Integer(1), heap.remove());
        System.out.println(heap);
    }

    @Test
    public void add_heap_return_false_if_heap_is_full() throws Exception {
        Heap<Integer> heap = new Heap<>(1);
        heap.add(1);
        assertFalse(heap.add(2));
    }

    @Test
    public void decrementKey_in_heap() throws Exception {
        Heap<Integer> heap = new Heap<>(10);
        heap.add(4);
        heap.add(2);
        heap.add(3);
        heap.decreaseKey(1, 1);
        System.out.println(heap);
        Assert.assertEquals(new Integer(1), heap.remove());
        System.out.println(heap);
    }

    @Test
    public void heapify_array() throws Exception {
        Integer[] arr = {5, 4, 3, 2, 1};
        Heap<Integer> heap = new Heap<>(arr.length);
        heap.heapify(arr);
        Integer[] expected = {1, 2, 3, 5, 4};
        Assert.assertArrayEquals(expected, arr);
    }

    @Test
    public void createMaxHeapWithCompartor() {
        Heap<Integer> heap = new Heap<>(10, (o1, o2) -> o2 - o1);
        heap.add(2);
        heap.add(4);
        heap.add(3);
        Assert.assertEquals(new Integer(4), heap.remove());
        Assert.assertEquals(new Integer(3), heap.remove());
        Assert.assertEquals(new Integer(2), heap.remove());
    }
}