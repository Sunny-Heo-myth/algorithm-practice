package org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedeque;

import java.util.ArrayDeque;
import java.util.Deque;

public class BJ18258 {

    private Deque<Integer> deque = new ArrayDeque<>();

    private static final String POP = "pop";
    private static final String SIZE = "size";
    private static final String EMPTY = "empty";
    private static final String FRONT = "front";
    private static final String BACK = "back";

    public String solve(String input) {
        StringBuilder sb = new StringBuilder();
        String[] s = input.split("\n");

        for (int i = 1; i < s.length; i++) {
            operate(s, i, sb);
        }

        return sb.length() == 0 ? "" : sb.deleteCharAt(sb.length() - 1).toString();
    }

    private void operate(String[] s, int i, StringBuilder sb) {
        switch (s[i]) {

            case POP:
                sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
                break;

            case SIZE:
                sb.append(deque.size()).append("\n");
                break;

            case EMPTY:
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                break;

            case FRONT:
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
                break;

            case BACK:
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                break;

            default:
                deque.addFirst(Integer.parseInt(s[i].split(" ")[1]));
        }
    }
}
