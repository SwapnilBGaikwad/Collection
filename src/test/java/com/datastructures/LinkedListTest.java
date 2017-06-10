package com.datastructures;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {
    @Test
    public void add_element_in_linkedList_for_1_element() {
        final List<Integer> list = new LinkedList<>();

        list.add( 5 );

        assertEquals( 1, list.size() );
        assertEquals( new Integer( 5 ), list.get( 0 ) );
    }

    @Test
    public void add_element_in_linkedList_for_2_element() {
        final List<Integer> list = new LinkedList<>();
        list.add( 1 );
        list.add( 2 );

        assertEquals( 2, list.size() );
        assertEquals( new Integer( 1 ), list.get( 0 ) );
        assertEquals( new Integer( 2 ), list.get( 1 ) );
    }

    @Test
    public void return_size_0_if_linkedList_is_empty() {
        final List<Integer> list = new LinkedList<>();
        assertEquals( 0, list.size() );
    }
}