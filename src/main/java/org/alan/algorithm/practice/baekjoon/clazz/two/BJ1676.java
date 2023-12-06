package org.alan.algorithm.practice.baekjoon.clazz.two;

public class BJ1676 {
    private int two = 0;
    private int five = 0;
    public String solve(String input) {
        for (int i = 1; i <= Integer.parseInt(input); i++) {
            int n = i;
            while (n % 2 == 0) {
                n /= 2;
                two++;
            }
            while (n % 5 == 0) {
                n /= 5;
                five++;
            }
        }
        return String.valueOf(Integer.min(two, five));
    }
}
