package org.alan.algorithm.practice.baekjoon.clazz.two;

public class BJ10845 {
    private int[] array;
    private int pointer = 0;
    private int backPointer = 0;

    public String solve(String input) {
        String[] s = input.split("\n");
        array = new int[Integer.parseInt(s[0])];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < s.length; i++) {
            String[] ss = s[i].split(" ");
            if (ss.length == 2) {
                push(Integer.parseInt(ss[1]));
            } else {
                sb.append(operate(s[i])).append("\n");
            }
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public int operate(String input) {
        switch (input) {
            case "pop": return pop();
            case "size": return size();
            case "empty": return empty();
            case "front": return front();
            case "back": return back();
            default: throw new IllegalArgumentException();
        }
    }

    private void push(int i) {
        array[backPointer++] = i;
    }

    private int back() {
        if (pointer == backPointer) return -1;
        return array[backPointer - 1];
    }

    private int front() {
        if (pointer == backPointer) return -1;
        return array[pointer];
    }

    private int size() {
        return backPointer - pointer;
    }

    private int pop() {
        if (pointer == backPointer) return -1;
        return array[pointer++];
    }

    private int empty() {
        return pointer == backPointer ? 1 : 0;
    }
}
