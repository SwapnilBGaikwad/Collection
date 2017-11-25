package com.datastructures;

public class Queue<T> {
    private Node front;
    private Node rear;
    private int size = 0;

    public Queue() {
        size = 0;
    }

    public void add( T data ) {
        final Node node = new Node( data );
        if ( front == null ) {
            front = node;
            rear = node;
            size = 1;
            return;
        }
        rear.next = node;
        rear = node;
        size++;
    }

    public T remove() {
        if ( front == null ) {
            throw new IllegalStateException( "Queue is empty" );
        }
        T data = front.data;
        front = front.next;
        if ( front == null ) {
            rear = null;
        }
        size--;
        return data;
    }

    public T element() {
        if ( front == null ) {
            throw new IllegalStateException( "Queue is empty" );
        }
        return front.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        private final T data;
        public Node next;

        Node( T data ) {
            this.data = data;
        }
    }
}
