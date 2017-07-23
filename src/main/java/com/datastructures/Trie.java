package com.datastructures;

public class Trie {
    private Node head;

    public Trie() {
        head = new Node();
    }

    public void add(String value) {
        add(value, 0, head);
    }

    private void add(String value, int index, Node current) {
        if (value.length() == index) {
            return;
        }
        char aChar = value.charAt(index);
        Node child = current.getChild(aChar);
        if (child != null) {
            add(value, index + 1, child);
        } else {
            current.addChild(aChar);
            add(value, index + 1, current.getChild(aChar));
        }
    }

    public boolean find(String value) {
        return find(value, 0, head);
    }

    private boolean find(String value, int index, Node current) {
        if (value.length() == index) {
            return true;
        }
        char aChar = value.charAt(index);
        Node child = current.getChild(aChar);
        if (child == null) {
            return false;
        }
        return find(value, index + 1, child);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        toString(result, current);
        return result.toString();
    }

    private void toString(StringBuilder result, Node current) {
        for (int i = 0; i < 26; i++) {
            if (current.children[i] != null) {
                char ch = (char) (i + 97);
                result.append(ch).append(" ");
                toString(result, current.children[i]);
            }
        }
        result.append("\t");
    }

    private class Node {
        private final Node[] children = new Node[26];

        private int getChildrenIndex(char ch) {
            return ch - 97;
        }

        public void addChild(char current) {
            int index = getChildrenIndex(current);
            children[index] = new Node();
        }

        public Node getChild(char aChar) {
            return children[getChildrenIndex(aChar)];
        }
    }
}
