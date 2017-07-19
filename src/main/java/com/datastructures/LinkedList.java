package com.datastructures;

import java.util.*;

class LinkedList<E> implements List<E> {

    private Node head;
    private int size;

    LinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override public int size() {
        return size;
    }

    @Override public boolean isEmpty() {
        return head == null;
    }

    @Override public boolean contains( Object o ) {
        Node current = head;
        while ( current != null ) {
            if ( Objects.equals( current.data, o ) ) {
                return true;
            }
            current = current.link;
        }
        return false;
    }

    @Override public Iterator<E> iterator() {
        // TODO Default implementation
        return null;
    }

    @Override public Object[] toArray() {
        // TODO Default implementation
        return new Object[0];
    }

    @Override public <T> T[] toArray( T[] a ) {
        // TODO Default implementation
        return null;
    }

    @Override public boolean add( E data ) {
        final Node node = new Node( data );
        if ( head == null ) {
            head = node;
            size = 1;
            return true;
        }
        Node pointer = head;
        while ( pointer.link != null ) {
            pointer = pointer.link;
        }
        pointer.link = node;
        size++;
        return true;
    }

    @Override public boolean remove( Object o ) {
        Node current = head;
        Node previous = null;
        while ( current != null ) {
            if ( Objects.equals( current.data, o ) ) {
                if ( previous == null ) {
                    head = head.link;
                } else {
                    previous.link = current.link;
                }
                return true;
            }
            previous = current;
            current = current.link;
        }
        return false;
    }

    @Override public boolean containsAll( Collection<?> c ) {
        // TODO Default implementation
        return false;
    }

    @Override public boolean addAll( Collection<? extends E> c ) {
        // TODO Default implementation
        return false;
    }

    @Override public boolean addAll( int index, Collection<? extends E> c ) {
        // TODO Default implementation
        return false;
    }

    @Override public boolean removeAll( Collection<?> c ) {
        // TODO Default implementation
        return false;
    }

    @Override public boolean retainAll( Collection<?> c ) {
        // TODO Default implementation
        return false;
    }

    @Override public void clear() {

    }

    @Override public E get( int index ) {
        Node pointer = head;
        int counter = 0;
        while ( counter < index ) {
            pointer = head.link;
            counter++;
        }
        return pointer.data;
    }

    @Override public E set( int index, E element ) {
        return null;
    }

    @Override public void add( int index, E element ) {

    }

    @Override public E remove( int index ) {
        return null;
    }

    @Override public int indexOf( Object o ) {
        return 0;
    }

    @Override public int lastIndexOf( Object o ) {
        return 0;
    }

    @Override public ListIterator<E> listIterator() {
        return null;
    }

    @Override public ListIterator<E> listIterator( int index ) {
        Comparator[] comparator = new Comparator[10];
        return null;
    }

    @Override public List<E> subList( int fromIndex, int toIndex ) {
        return null;
    }

    private class Node {
        private final E data;
        private Node link;

        Node( E data ) {
            this.data = data;
            link = null;
        }
    }
}
