package org.alan.algorithm.practice.baekjoon.level.two;

public class BJ10866 {
    private int[] array;
    private int pointer;
    private int backPointer;

    public String solve(String input) {
        String[] s = input.split("\n");
        int n = Integer.parseInt(s[0]);
        array = new int[n * 2 + 1];
        pointer = n + 1;
        backPointer = n + 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < s.length; i++) {
            String[] ss = s[i].split(" ");
            if (ss.length == 2) {
                if (ss[0].equals("push_front")) {
                    push_front(Integer.parseInt(ss[1]));
                } else {
                    push_back(Integer.parseInt(ss[1]));
                }

            } else {
                sb.append(operate(s[i])).append("\n");
            }
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public int operate(String input) {
        switch (input) {
            case "pop_front": return pop_front();
            case "pop_back": return pop_back();
            case "size": return size();
            case "empty": return empty();
            case "front": return front();
            case "back": return back();
            default: throw new IllegalArgumentException();
        }
    }

    private void push_front(int i) {
        array[--pointer] = i;   // todo : pointer can go below 0
    }

    private void push_back(int i) {
        array[backPointer++] = i;
    }

    private int pop_front() {
        if (pointer == backPointer) return -1;
        return array[pointer++];
    }

    private int pop_back() {
        if (pointer == backPointer) return -1;
        return array[--backPointer];
    }

    private int front() {
        if (pointer == backPointer) return -1;
        return array[pointer];
    }

    private int back() {
        if (pointer == backPointer) return -1;
        return array[backPointer - 1];
    }

    private int size() {
        return backPointer - pointer;
    }

    private int empty() {
        return pointer == backPointer ? 1 : 0;
    }
}
