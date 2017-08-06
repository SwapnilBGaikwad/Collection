package com.datastructures;

public class Queue<T> {
    private Node front;
    private Node rear;

    public void add( T data ) {
        final Node node = new Node( data );
        if ( front == null ) {
            front = node;
            rear = node;
            return;
        }
        rear.next = node;
        rear = node;
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
        return data;
    }

    public T element() {
        if ( front == null ) {
            throw new IllegalStateException( "Queue is empty" );
        }
        return front.data;
    }

    private class Node {
        private final T data;
        public Node next;

        Node( T data ) {
            this.data = data;
        }
    }
}
