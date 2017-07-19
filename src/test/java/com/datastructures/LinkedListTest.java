package com.datastructures;

import org.junit.Assert;
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
        assertEquals( 0, new LinkedList<>().size() );
    }

    @Test
    public void isEmpty_return_true_if_element_not_present() {
        final LinkedList<String> list = new LinkedList<>();
        assertEquals( true, list.isEmpty() );
    }

    @Test
    public void isEmpty_return_false_if_element_present() {
        final LinkedList<String> list = new LinkedList<>();
        list.add( "dummy string" );
        assertEquals( false, list.isEmpty() );
    }

    @Test
    public void returns_true_if_element_is_present() {
        final LinkedList<String> list = new LinkedList<>();
        list.add( "A" );
        list.add( "B" );
        list.add( "C" );
        list.add( "D" );
        list.add( "E" );

        Assert.assertEquals( true, list.contains( "B" ) );
    }

    @Test
    public void returns_false_if_element_not_present() {
        final LinkedList<String> list = new LinkedList<>();
        list.add( "A" );
        list.add( "B" );

        Assert.assertEquals( false, list.contains( "C" ) );
    }

    @Test
    public void remove_from_list() {
        final LinkedList<String> list = new LinkedList<>();
        list.add( "A" );
        list.add( "B" );
        list.add( "C" );
        list.add( "D" );

        Assert.assertEquals( true, list.remove( "B" ) );
    }

}