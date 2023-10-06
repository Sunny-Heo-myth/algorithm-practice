package org.alan.algorithm.practice.baekjoon.level.two;

import java.util.Arrays;

public class BJ1920 {
    public String solve(String input) {
        String[] s = input.split("\n");
        int[] array = Arrays.stream(s[1].split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()   // O(NlgN)
                .toArray();

        int[] numbersToFind = Arrays.stream(s[3].split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        StringBuilder sb = new StringBuilder();
        for (int i : numbersToFind) {
            if (binarySearch(array, 0, array.length, i) != -1) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private int binarySearch(int[] array, int from, int to, int x) {    // O(lgN)
        if (from + 1 >= to) {
            if (array[from] == x) return from;
            else return -1;
        }

        int middle = (from + to) / 2; int i = array[middle];
        if (x == i) return middle;
        else if (x > i) return binarySearch(array, middle, to, x);
        else return binarySearch(array, from, middle, x);
    }
}
