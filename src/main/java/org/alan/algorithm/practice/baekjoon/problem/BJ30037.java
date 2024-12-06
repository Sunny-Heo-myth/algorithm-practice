package org.alan.algorithm.practice.baekjoon.problem;

import java.util.*;

public class BJ30037 {
    public String solve(String input) {
        String[] words = input.split(" ");
        Stack<String> afterOf = new Stack<>();

        // loop invariant
        // 1. 'i' is pointing next target of word to read.
        // 2. 'answer' has all the words processed before 'i'.
        for (int i = 0; i < words.length; i++)

            if (words[i].equals("of")
                    && !afterOf.isEmpty()
                    && !List.of('!', '?', ',', '.').contains(afterOf.peek().charAt(afterOf.peek().length() - 1))
                    && i + 1 < words.length
                    && List.of("Korea", "Korea.", "Korea!", "Korea,", "Korea?").contains(words[i + 1])) {
                afterOf.push("K-"
                        + capitalize(afterOf.pop())
                        + (words[i + 1].length() > 5 ? words[i + 1].charAt(5) : ""));
                i++;

            } else afterOf.push(words[i]);

        int count = 0;
        Deque<String> answer = new ArrayDeque<>();
        while (!afterOf.isEmpty()) {

            String s = afterOf.pop();
            while (!afterOf.isEmpty() && afterOf.peek().equals("Korea")) {
                afterOf.pop();
                count++;
            }

            answer.offerFirst("K-".repeat(count) + (count > 0 ? capitalize(s) : s));
            count = 0;
        }

        return String.join(" ", answer);
    }

    private String capitalize(String pop) {
        char first = pop.charAt(0);
        return (char) (first > 96 ? first - 32 : first)
                + pop.substring(1);
    }

}
