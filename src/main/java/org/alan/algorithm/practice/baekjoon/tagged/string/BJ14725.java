package org.alan.algorithm.practice.baekjoon.tagged.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

public class BJ14725 {
    public String solve(String input) {
        Node root = new Node(0);
        input.lines().skip(1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).skip(1).toArray(String[]::new))
                .forEach(root::insert);
        return root.print();
    }
}

class Node {
    private final int depth;
    private final Map<String, Node> children = new HashMap<>();

    public Node(int depth) {
        this.depth = depth;
    }

    void insert(String[] topToBottom) {
        Node current = this;
        for (String str : topToBottom) {
            current.children.putIfAbsent(str, new Node(current.depth + 1));
            current = current.children.get(str);
        }
    }

    String print() {
        StringBuilder sb = new StringBuilder();
        Stack<String> keyStack = new Stack<>();
        Stack<Node> nodeStack = new Stack<>();

        nodeStack.push(this);
        keyStack.push("");

        while (!nodeStack.empty()) {
            Node popNode = nodeStack.pop();
            String popKey = keyStack.pop();
            if (popNode.depth > 0) sb.append("--".repeat(popNode.depth - 1)).append(popKey).append("\n");

            popNode.children.keySet().stream().sorted(Comparator.reverseOrder()).forEach(child -> {
                nodeStack.push(popNode.children.get(child));
                keyStack.push(child);
            });
        }
        return sb.toString();
    }
}

