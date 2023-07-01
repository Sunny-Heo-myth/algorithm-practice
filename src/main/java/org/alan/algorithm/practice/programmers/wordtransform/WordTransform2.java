package org.alan.algorithm.practice.programmers.wordtransform;

import java.util.*;

public class WordTransform2 {
    private String[] words;
    private Set<Node> nodes;


    public int solution(String begin, String target, String[] words) {
        if (!checkWords(target)) {
            return 0;
        }

        this.words = words;
        Node startNode = new Node(begin);

        nodes.add(startNode);
        for (String word : words) {
            nodes.add(new Node(word));
        }

        for (Node node : nodes) {
            node.setConnections(nodes);
        }

        return iterate(startNode, target);
    }

    private boolean checkWords(String target) {
        for (String word : words) {
            if (Objects.equals(word, target)) {
                return true;
            }
        }
        return false;
    }

    private int iterate(Node startNode, String target) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (Objects.equals(node.value, target)) {
            }
        }
        return 0;
    }

    class Node {
        private final String value;
        private List<Node> connections;

        Node(String value) {
            this.value = value;
        }

        private void setConnections(Set<Node> nodes) {
            for (Node word : nodes) {
                if (compare(value, word.value)) {
                    connections.add(word);
                }
            }
        }

        private void deleteConnection(Node node) {
            connections.remove(node);
        }

        private boolean compare(String word1, String word2) {
            int wordLength = word1.length();
            int unMatch = 0;
            int i = 0;
            while (unMatch < 2 && i < wordLength) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    unMatch++;
                }
                i++;
            }
            return unMatch == 1;
        }

    }
}
