package org.alan.algorithm.practice.baekjoon.clazz.four;

public class BJ1991 {

    private final Node root = Node.of('A', null, null);
    private final StringBuilder sb = new StringBuilder();

    public String solve(String input) {
        String[] s = input.split("\n");
        for (int i = 1; i < Integer.parseInt(s[0]) + 1; i++) {
            String[] ss = s[i].split(" ");
            insertNode(root, ss[0].charAt(0), ss[1].charAt(0), ss[2].charAt(0));
        }

        printPreOrder(root);
        sb.append("\n");
        printInOrder(root);
        sb.append("\n");
        printPostOrder(root);

        return sb.toString();
    }

    private void insertNode(Node currentNode, char newValue, char newLeft, char newRight) {
        if (currentNode.value == newValue) {
            currentNode.left = newLeft == '.' ? null : Node.of(newLeft, null, null);
            currentNode.right = newRight == '.' ? null : Node.of(newRight, null, null);
            return;
        }

        if (currentNode.left != null) insertNode(currentNode.left, newValue, newLeft, newRight);
        if (currentNode.right != null) insertNode(currentNode.right, newValue, newLeft, newRight);
    }

    private void printPreOrder(Node node) {
        if (node == null) return;

        sb.append(node.value);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    private void printInOrder(Node node) {
        if (node == null) return;

        printInOrder(node.left);
        sb.append(node.value);
        printInOrder(node.right);
    }

    private void printPostOrder(Node node) {
        if (node == null) return;

        printPostOrder(node.left);
        printPostOrder(node.right);
        sb.append(node.value);
    }

    private static class Node {
        private char value;
        private Node left;
        private Node right;

        private static Node of(char value, Node left, Node right) {
            Node newNode = new Node();
            newNode.value = value;
            newNode.left = left;
            newNode.right = right;
            return newNode;
        }
    }

}
