package com.datastructures;

/*
 * Tree class is implemented as BST.
 * E should implement Comparable interface to compare two objects.
 */
public class Tree<E extends Comparable<E>> {
    private Node root;

    public void add( E data ) {
        final Node node = new Node( data );
        if ( root == null ) {
            root = node;
            return;
        }
        Node current = root;
        while ( true ) {
            if ( data.compareTo( current.data ) < 0 ) {
                if ( current.left == null ) {
                    current.left = node;
                    break;
                } else {
                    current = current.left;
                }
            } else {
                if ( current.right == null ) {
                    current.right = node;
                    break;
                } else {
                    current = current.right;
                }
            }
        }
    }

    public boolean contains( E data ) {
        return contains( data, root );
    }

    private boolean contains( E data, Node root ) {
        if ( root == null ) {
            return false;
        }
        if ( root.data == data ) {
            return true;
        }
        if ( data.compareTo( root.data ) < 0 ) {
            return contains( data, root.left );
        } else {
            return contains( data, root.right );
        }
    }

    public boolean remove( E data ) {
        final boolean isPresent = contains( data );
        root = remove( root, data );
        return isPresent;
    }

    private Node remove( Node root, E data ) {
        // If tree is not empty
        if ( root == null ) {
            return null;
        }

        if ( data.compareTo( root.data ) < 0 ) {
            root.left = remove( root.left, data );
        } else if ( data.compareTo( root.data ) > 0 ) {
            root.right = remove( root.right, data );
        } else {
            if ( root.left == null ) {
                return root.right;
            }
            if ( root.right == null ) {
                return root.left;
            }
            //Element found
            root.data = minValue( root.right );
            root.right = remove( root.right, root.data );
        }
        return root;
    }

    private E minValue( Node root ) {
        while ( root.left != null ) {
            root = root.left;
        }
        return root.data;
    }

    private class Node {
        private E data;
        private Node left;
        private Node right;

        public Node( E data ) {
            this.data = data;
        }

        @Override public String toString() {
            return String.valueOf( data );
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }
    }
}
