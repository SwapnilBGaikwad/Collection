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

    public boolean find( E data ) {
        return find( data, root );
    }

    private boolean find( E data, Node root ) {
        if ( root == null ) {
            return false;
        }
        if ( root.data == data ) {
            return true;
        }
        if ( data.compareTo( root.data ) < 0 ) {
            return find( data, root.left );
        } else {
            return find( data, root.right );
        }
    }

    public boolean remove( E data ) {
        if ( root.data == data ) {
            return false;
        }
        Node parent = findParent( root, data );
        if ( parent == null ) {
            return false;
        }
        Node current;
        if ( parent.left != null && parent.left.data == data ) {
            current = parent.left;
        } else {
            current = parent.right;
        }
        remove( parent, current );
        return true;
    }

    private void remove( Node parent, Node current ) {
        if ( current.isLeaf() ) {
            if ( parent.left == current ) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return;
        }
        if ( current.left == null ) {
            if ( parent.left == current ) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
            return;
        }
        if ( current.right == null ) {
            if ( parent.left == current ) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
            return;
        }
        Node itr = current.right;
        parent = current;
        while ( itr.left != null ) {
            parent = itr;
            itr = itr.left;
        }
        current.data = itr.data;
        remove( parent, itr );
    }

    private Node findParent( Node current, E data ) {
        if ( current == null || current.data == data ) {
            return null;
        }
        if ( current.left != null && current.left.data == data ) {
            return current;
        } else if ( current.right != null && current.right.data == data ) {
            return current;
        } else if ( data.compareTo( current.data ) < 0 ) {
            return findParent( current.left, data );
        } else {
            return findParent( current.right, data );
        }
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
