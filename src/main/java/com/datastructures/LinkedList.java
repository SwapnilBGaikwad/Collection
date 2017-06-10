package com.datastructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
        return false;
    }

    @Override public boolean contains( Object o ) {
        return false;
    }

    @Override public Iterator<E> iterator() {
        return null;
    }

    @Override public Object[] toArray() {
        return new Object[0];
    }

    @Override public <T> T[] toArray( T[] a ) {
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
        return false;
    }

    @Override public boolean containsAll( Collection<?> c ) {
        return false;
    }

    @Override public boolean addAll( Collection<? extends E> c ) {
        return false;
    }

    @Override public boolean addAll( int index, Collection<? extends E> c ) {
        return false;
    }

    @Override public boolean removeAll( Collection<?> c ) {
        return false;
    }

    @Override public boolean retainAll( Collection<?> c ) {
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
