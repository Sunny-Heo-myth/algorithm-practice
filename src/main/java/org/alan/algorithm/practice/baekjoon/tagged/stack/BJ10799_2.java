package org.alan.algorithm.practice.baekjoon.tagged.stack;

public class BJ10799_2 {
    private final String state;

    public BJ10799_2(String input) {
        state = input;
    }

    public String solve() {
        int count = 0, cut = 0;
        for (int i = 0; i < state.length(); i++) {
            if (state.charAt(i) == '(') {
                if (state.charAt(i + 1) == ')') {
                    count += cut;
                    i++;
                } else {
                    cut++;
                }

            } else {
                cut--;
                count++;
            }
        }
        return String.valueOf(count);
    }
}
