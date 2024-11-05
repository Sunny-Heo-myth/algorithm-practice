package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Stack;
import java.util.regex.Pattern;

public class BJ3015 {
    public String solve(String input) {
        int[] heights = Pattern.compile("\n").splitAsStream(input).skip(1)
                .mapToInt(Integer::parseInt).toArray();
        long answer = 0;

        Stack<Person> stack = new Stack<>();
        for (long height : heights) {
            long count = 1;

            while (!stack.isEmpty()) {
                Person peek = stack.peek();
                if (peek.height > height) break;
                if (peek.height == height) count += peek.count;
                answer += peek.count;
                stack.pop();
            }

            if (!stack.isEmpty()) answer++;
            stack.push(new Person(height, count));
        }

        return String.valueOf(answer);
    }

    static class Person {
        private final long height;
        private final long count;

        public Person(long height, long count) {
            this.height = height;
            this.count = count;
        }
    }
}
