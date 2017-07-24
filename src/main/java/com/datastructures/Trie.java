package com.datastructures;

import java.util.HashMap;

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
        for (Character ch : current.children.keySet()) {
            result.append(ch).append(" ");
            toString(result, current.getChild(ch));
        }
        result.append("\t");
    }

    private class Node {
        private final HashMap<Character, Node> children;

        public Node() {
            children = new HashMap<>();
        }

        public void addChild(char current) {
            children.put(current, new Node());
        }

        public Node getChild(char aChar) {
            return children.get(aChar);
        }
    }
}
