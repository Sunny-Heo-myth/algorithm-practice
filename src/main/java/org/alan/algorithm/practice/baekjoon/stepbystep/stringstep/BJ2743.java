package org.alan.algorithm.practice.baekjoon.stepbystep.stringstep;

public class BJ2743 {
    public int solve(String input) {
        char[] chars = input.toCharArray();
        int size = 0;
        for (char ch : chars) {
            size++;
        }
        return size;
    }
}
