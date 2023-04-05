package org.alan.algorithm.practice.baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ9012_2 {

    public static final char LEFT_PARENTHESES = '(';
    //public static final char rightParentheses = ')';

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(bf.readLine());
        for (int i = 0; i < inputCount; i++) {
            String string = bf.readLine();
            System.out.println(vps(string));
            System.out.println(args[0]);
        }
    }

    public static String vps(String input) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        while (count < input.length()) {

            if (input.charAt(count) == LEFT_PARENTHESES) {
                stack.push(0);
            } else {

                if (stack.isEmpty()) {
                    return "NO";
                } else {
                    stack.pop();
                }
            }

            count += 1;
        }

        if (!stack.isEmpty()) {
            return "NO";
        } else {
            return "YES";
        }

    }
}


