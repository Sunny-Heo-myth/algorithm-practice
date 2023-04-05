package org.alan.algorithm.practice.programmers.network;

import java.util.Stack;

public class Network {
    private boolean[] computerArray;
    private int[][] networkArray;
    Stack<Integer> stack;

    public int solution(int input1, int[][] input2) {
        int networkCount = 0;
        computerArray = new boolean[input1];
        networkArray = input2;

        for (int i = 0; i < input1; i++) {
            if (!computerArray[i]) {
                networkCount++;
                dfs(i);
            }
        }
        return networkCount;
    }

    private void dfs(int node) {
        stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Integer currentNode = stack.pop();
            for (int i = 0; i < networkArray[0].length; i++) {
                if (networkArray[currentNode][i] == 1) {
                    networkArray[currentNode][i] = 0;
                    push(i);
                }
            }
        }
    }

    private void push(Integer node){
        computerArray[node] = true;
        stack.push(node);
    }

}
