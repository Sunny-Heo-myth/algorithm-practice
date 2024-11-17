package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ22866 {
    public String solve(String input) {
        int[] arr = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToInt(Integer::parseInt).toArray();

        Stack<Integer> rightStack = new Stack<>(), leftStack = new Stack<>();
        int[][] right = new int[arr.length][2], left = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int j = arr.length - i - 1;
            while (!rightStack.isEmpty() && arr[j] >= arr[rightStack.peek()]) rightStack.pop();
            while (!leftStack.isEmpty() && arr[i] >= arr[leftStack.peek()]) leftStack.pop();
            right[j][0] = rightStack.size();
            right[j][1] = rightStack.isEmpty() ? 0 : rightStack.peek() + 1;
            left[i][0] = leftStack.size();
            left[i][1] = leftStack.isEmpty() ? 0 : leftStack.peek() + 1;
            rightStack.push(j);
            leftStack.push(i);
        }

        return IntStream.range(0, arr.length).mapToObj(i -> {
            int rightSize = right[i][0], leftSize = left[i][0];
            int rightPeek = right[i][1], leftPeek = left[i][1];
            if (rightSize == 0 && leftSize == 0) return "0";
            else if (rightSize == 0) return leftSize + " " + leftPeek;
            else if (leftSize == 0) return rightSize + " " + rightPeek;

            int idx = i + 1, size = leftSize + rightSize;
            return idx - leftPeek > rightPeek - idx ? size + " " + rightPeek : size + " " + leftPeek;
        }).collect(Collectors.joining("\n"));
    }
}
