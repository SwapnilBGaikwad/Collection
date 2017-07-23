package com.datastructures;

public class Heap {
    private int[] array;
    private int index;

    public Heap(int capacity) {
        this.array = new int[capacity];
        this.index = 0;
    }

    public boolean add(int data) {
        if (index == array.length) {
            return false;
        }
        array[index] = data;
        reHeapUp(index);
        index++;
        return true;
    }

    public int remove() {
        if (index == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int data = array[0];
        swap(array, index - 1, 0);
        index--;
        reHeapDown(0);
        return data;
    }

    public void decreaseKey(int i, int newKey) {
        if (newKey > array[i]) {
            throw new IllegalArgumentException("Invalid key : " + newKey);
        }
        array[i] = newKey;
        reHeapUp(i);
    }

    public void heapify(int[] arr) {
        array = arr;
        index = arr.length;
        for (int i = arr.length / 2; i >= 0; i--) {
            reHeapDown(i);
        }
    }

    private void reHeapUp(int index) {
        if (index == 0) {
            return;
        }
        int parent = parent(index);
        if (array[parent] > array[index]) {
            swap(array, parent, index);
            reHeapUp(parent);
        }
    }

    private void reHeapDown(int index) {
        int left = left(index);
        int right = right(index);
        int minimum = index;
        if (left < this.index && array[minimum] > array[left]) {
            minimum = left;
        }
        if (right < this.index && array[minimum] > array[right]) {
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

    private void swap(int[] array, int i, int j) {
        array[i] = array[i] + array[j];
        array[j] = array[i] - array[j];
        array[i] = array[i] - array[j];
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]).append(" ");
        }
        return result.toString();
    }
}
