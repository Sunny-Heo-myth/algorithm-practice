package org.alan.algorithm.practice.baekjoon.bronze.two;

public class BJ1225 {
    public String solve(String input) {
        String[] s = input.split(" ");
        return String.valueOf(s[0].chars().mapToLong(i -> i - '0').map(i ->
                s[1].chars().map(j -> j - '0').mapToLong(j -> i * j).sum()).sum());
    }
}
