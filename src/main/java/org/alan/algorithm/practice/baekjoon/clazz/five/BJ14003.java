package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.Collections;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ14003 {
    private int[] minLastMemo;

    public String solve(String input) {
        int[] arr = input.lines().skip(1).flatMapToInt(s ->
                Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt)).toArray();
        minLastMemo = new int[arr.length + 1]; minLastMemo[0] = Integer.MIN_VALUE;
        int[] LISLengthMemo = new int[arr.length];

        int length = 0;
        int idx;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > minLastMemo[length]) {
                LISLengthMemo[i] = ++length;
                minLastMemo[length] = arr[i];
            } else {
                idx = bSearch(length, arr[i]);
                LISLengthMemo[i] = idx;
                minLastMemo[idx] = arr[i];
            }
        }

        Stack<Integer> stack = new Stack<>(); String answer = length + "\n";
        for (int i = arr.length - 1; i >= 0; i--) if (LISLengthMemo[i] == length) {
            stack.push(arr[i]);
            length--;
        }
        Collections.reverse(stack);
        return answer + stack.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    private int bSearch(int right, int key) {
        int left = 0;
        while (left < right) {
            int mid = (right) / 2;
            if (minLastMemo[mid] > key) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}
