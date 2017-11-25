package com.datastructures;

import java.util.HashMap;

public class Trie {
    private Node head;

    public Trie() {
        head = new Node();
    }

    public void add( String value ) {
        Node current = head;
        for ( char aChar : value.toCharArray() ) {
            final Node child = current.getChild( aChar );
            if ( child == null ) {
                current.addChild( aChar );
                current = current.getChild( aChar );
            } else {
                current = child;
            }
        }
    }

    public boolean find( String value ) {
        Node current = head;
        for ( char aChar : value.toCharArray() ) {
            final Node child = current.getChild( aChar );
            if ( child == null ) {
                return false;
            }
            current = child;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        toString( result, current );
        return result.toString();
    }

    private void toString( StringBuilder result, Node current ) {
        for ( Character ch : current.children.keySet() ) {
            result.append( ch ).append( " " );
            toString( result, current.getChild( ch ) );
        }
        result.append( "\t" );
    }

    private class Node {
        private final HashMap<Character, Node> children;

        Node() {
            children = new HashMap<>();
        }

        void addChild( char current ) {
            children.put( current, new Node() );
        }

        Node getChild( char aChar ) {
            return children.get( aChar );
        }
    }
}
