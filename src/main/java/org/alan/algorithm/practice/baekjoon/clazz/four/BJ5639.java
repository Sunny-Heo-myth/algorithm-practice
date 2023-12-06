package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.regex.Pattern;

public class BJ5639 {
    private final StringBuilder sb = new StringBuilder();
    public String solve(String input) {
        Node root = new Node(Integer.parseInt(input.split("\n")[0]));
        Pattern.compile("\n").splitAsStream(input).skip(1).mapToInt(Integer::parseInt).forEach(root::insert);
        postOrder(root);
        return sb.toString();
    }

    private void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value).append("\n");
    }

    private static class Node {
        private final int value;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
        }

        private void insert(int x) {
            if (value > x)
                if (left == null) left = new Node(x);
                else left.insert(x);
            else
                if (right == null) right = new Node(x);
                else right.insert(x);
        }
    }
}
