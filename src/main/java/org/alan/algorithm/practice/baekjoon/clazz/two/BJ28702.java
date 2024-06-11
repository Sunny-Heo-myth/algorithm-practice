package org.alan.algorithm.practice.baekjoon.clazz.two;

public class BJ28702 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        for (int i = 0; i < lines.length; i++) {
            if (isParsable(lines[i])) {
                int n = Integer.parseInt(lines[i]) + 3 - i;
                if (n % 3 == 0 && n % 5 == 0) return "FizzBuzz";
                else if (n % 3 == 0) return "Fizz";
                else if (n % 5 == 0) return "Buzz";
                else return String.valueOf(n);
            }
        }
        return "-1";
    }

    private boolean isParsable(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
