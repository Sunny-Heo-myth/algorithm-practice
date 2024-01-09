package org.alan.algorithm.practice.baekjoon.tagged.string;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BJ12904 {
    public String solve(String input) { // todo:
        String[] strings = input.split("\n");
        String s = strings[0]; String t = strings[1];

        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            String polled = queue.poll();

            if (Objects.equals(polled, t)) {
                return "1";
            }

            if (polled.length() == t.length()) {
                continue;
            }

            String next1 = polled + "A";

            if (t.startsWith(next1) || t.startsWith(new StringBuilder(next1).reverse().toString())) {
                queue.offer(next1);
            }

            String next2 = reverseAppendB(polled);

            if (t.startsWith(next2) || t.startsWith(new StringBuilder(next2).reverse().toString())) {
                queue.offer(next2);
            }
        }
        return "0";
    }

    private String reverseAppendB(String s) {
        return new StringBuilder(s).reverse().append("B").toString();
    }

    public String solve2(String input) {
        String[] strings = input.split("\n");
        StringBuilder s = new StringBuilder(strings[0]);
        StringBuilder t = new StringBuilder(strings[1]);

        while (s.length() < t.length()) {
            if (t.charAt(t.length() - 1) == 'A') {
                t.deleteCharAt(t.length() - 1);
            } else if (t.charAt(t.length() - 1) == 'B') {
                t.deleteCharAt(t.length() - 1);
                t.reverse();
            }
        }

        if (t.toString().contentEquals(s)) return "1";
        else return "0";
    }
}
