package org.alan.algorithm.practice.baekjoon.clazz.two;

/*
1 이상 99999 이하
 */
public class BJ1259 {
    public String solve(String input) {
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return "no";
            }
        }
        return "yes";
    }
}
