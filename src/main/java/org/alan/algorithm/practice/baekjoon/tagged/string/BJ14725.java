package org.alan.algorithm.practice.baekjoon.tagged.string;

import java.util.*;
import java.util.stream.Collectors;

public class BJ14725 {
    public String solve(String input) {
        TrieNode root = new TrieNode(0);
        input.lines().skip(1).forEach(s -> root.insert(
                Arrays.stream(s.split(" ")).skip(1).collect(Collectors.joining(","))));
        return root.print();
    }
}

class TrieNode {
    private final int depth;
    private final Map<String, TrieNode> children = new HashMap<>();

    public TrieNode(int depth) {
        this.depth = depth;
    }

    void insert(String ss) {
        TrieNode node = this;
        for (String s : ss.split(",")) {
            node.children.putIfAbsent(s, new TrieNode(node.depth + 1));
            node = node.children.get(s);
        }
    }

    String print() {
        StringBuilder sb = new StringBuilder();
        Stack<TrieNode> stack = new Stack<>();
        Stack<String> keyStack = new Stack<>();

        stack.push(this);
        keyStack.push("");

        while (!stack.isEmpty()) {
            TrieNode pop = stack.pop();
            String key = keyStack.pop();
            if (!key.isEmpty()) sb.append("--".repeat(pop.depth - 1)).append(key).append("\n");

            pop.children.keySet().stream().sorted(Comparator.reverseOrder()).forEach(s -> {
                stack.push(pop.children.get(s));
                keyStack.push(s);
            });
        }

        return sb.toString();
    }
}