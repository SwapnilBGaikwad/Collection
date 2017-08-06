package com.datastructures;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class QueueTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    private Queue<Integer> queue;

    @Before
    public void setUp() throws Exception {
        queue = new Queue<>();
    }

    @Test
    public void add_in_queue() {
        queue.add( 1 );
        queue.add( 2 );

        assertEquals( new Integer( 1 ), queue.element() );
    }

    @Test
    public void remove_queue() {
        queue.add( 1 );
        queue.add( 2 );

        assertEquals( new Integer( 1 ), queue.remove() );
        assertEquals( new Integer( 2 ), queue.remove() );
    }

    @Test
    public void remove_throw_exception_if_queue_is_empty() {
        exception.expect( IllegalStateException.class );
        exception.expectMessage( "Queue is empty" );
        queue.add( 1 );
        assertEquals( new Integer( 1 ), queue.remove() );
        queue.remove();
    }

    @Test
    public void element_return_1st_element_in_queue() {
        queue.add( 1 );
        queue.add( 2 );

        assertEquals( new Integer( 1 ), queue.element() );
    }

    @Test
    public void element_throws_Exception_if_queue_is_empty() {
        exception.expect( IllegalStateException.class );
        exception.expectMessage( "Queue is empty" );
        queue.element();
    }
}