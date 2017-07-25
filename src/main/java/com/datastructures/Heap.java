package com.datastructures;

import java.util.Comparator;

public class Heap<E> {
    private Object[] array;
    private int index;
    private Comparator<E> comparator;

    public Heap(int capacity) {
        this(capacity, null);
    }

    public Heap(int capacity, Comparator<E> comparator) {
        this.array = new Object[capacity];
        this.index = 0;
        this.comparator = comparator;
    }

    public boolean add(E data) {
        if (index == array.length) {
            return false;
        }
        array[index] = data;
        reHeapUp(index);
        index++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E remove() {
        if (index == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        E data = (E) array[0];
        swap(array, index - 1, 0);
        index--;
        reHeapDown(0);
        return data;
    }

    @SuppressWarnings("unchecked")
    public void decreaseKey(int i, E newKey) {
        Comparable<? super E> key = (Comparable<? super E>) newKey;
        if (key.compareTo((E) array[i]) > 0) {
            throw new IllegalArgumentException("Invalid key : " + newKey);
        }
        array[i] = newKey;
        reHeapUp(i);
    }

    public void heapify(E[] arr) {
        array = arr;
        index = arr.length;
        for (int i = arr.length / 2; i >= 0; i--) {
            reHeapDown(i);
        }
    }

    @SuppressWarnings("unchecked")
    private void reHeapUp(int index) {
        if (index == 0) {
            return;
        }
        int parent = parent(index);
        if (compareIsGreater(array[parent], array[index])) {
            swap(array, parent, index);
            reHeapUp(parent);
        }
    }

    @SuppressWarnings("unchecked")
    private boolean compareIsGreater(Object o1, Object o2) {
        E first = (E) o1;
        E second = (E) o2;
        if (comparator != null) {
            return comparator.compare(first, second) > 0;
        }
        Comparable<? super E> comparable = (Comparable<? super E>) o1;
        return comparable.compareTo(second) > 0;
    }

    private void reHeapDown(int index) {
        int left = left(index);
        int right = right(index);
        int minimum = index;
        if (left < this.index && compareIsGreater(array[minimum], array[left])) {
            minimum = left;
        }
        if (right < this.index && compareIsGreater(array[minimum], array[right])) {
            minimum = right;
        }
        if (minimum != index) {
            swap(array, minimum, index);
            reHeapDown(minimum);
        }
    }

    private int right(int index) {
        return 2 * index + 2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private void swap(Object[] array, int i, int j) {
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(array[i]).append(" ");
        }
        return result.toString();
    }
}
