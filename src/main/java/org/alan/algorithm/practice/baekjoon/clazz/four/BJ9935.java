package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.Stack;
import java.util.stream.Collectors;

public class BJ9935 {
    public String solve(String input) {
        String[] s = input.split("\n");
        String target = s[0];
        String bomb = s[1];
        while (target.contains(bomb)) {
            int index = target.indexOf(bomb);
            target = target.substring(0, index) + target.substring(index + bomb.length());
        }
        return target.isEmpty() ? "FRULA" : target;
    }

    public String solve2(String input) {
        String[] s = input.split("\n");
        String target = s[0];
        String regex = s[1];
        int length = regex.length();

        Stack<Character> stack = new Stack<>();
        for (char ch : target.toCharArray()) {
            stack.push(ch);

            if (stack.size() < length) continue;

            boolean flag = true;
            for (int i = 0; i < length; i++) if (stack.get(stack.size() - length + i) != regex.charAt(i)) {
                flag = false;
                break;
            }

            if (flag) for (int i = 0; i < length; i++) stack.pop();
        }
        return stack.isEmpty() ? "FRULA" : stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
