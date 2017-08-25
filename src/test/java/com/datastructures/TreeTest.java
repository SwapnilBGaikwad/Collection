package com.datastructures;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TreeTest {
    @Test
    public void add_node_in_tree() {
        final Tree<Integer> tree = new Tree<>();
        tree.add( 4 );
        tree.add( 8 );
        tree.add( 2 );
        tree.add( 1 );

        assertEquals( true, tree.contains( 2 ) );
        assertEquals( false, tree.contains( 5 ) );
    }

    @Test
    public void remove_node_in_tree() {
        final Tree<Integer> tree = new Tree<>();
        tree.add( 4 );
        tree.add( 8 );
        tree.add( 7 );
        tree.add( 2 );
        tree.add( 1 );
        tree.add( 3 );

        List<Integer> list = Arrays.asList( 4, 8, 7, 2, 1, 3 );
        list.forEach( element -> {
            System.out.println( element );
            assertEquals( true, tree.contains( element ) );
            assertEquals( true, tree.remove( element ) );
            assertEquals( false, tree.contains( element ) );
        } );
    }
}