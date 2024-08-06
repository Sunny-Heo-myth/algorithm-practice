package org.alan.algorithm.lab.datastructure;

public class BalancedTree {
    private final int width;
    private final RootNode root;

    public BalancedTree(int width) {
        this.width = width;
        this.root = new RootNode();
    }

    public Object find(String key) {
        return null;
    }

    public void insert(Object value) {
    }

    public void delete(Object value) {
    }

    private class Node {
        private final String[] keys;

        private Node() {
            this.keys = new String[width];
        }
    }

    private class RootNode extends NonLeafNode {

    }

    private class NonLeafNode extends Node {

    }

    private class LeafNode extends Node {

    }
}
