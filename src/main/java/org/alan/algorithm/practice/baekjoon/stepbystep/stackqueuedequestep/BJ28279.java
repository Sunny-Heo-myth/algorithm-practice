package org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedequestep;

import java.util.LinkedList;
import java.util.List;

public class BJ28279 {
    private final List<Integer> deque = new LinkedList<>();

    public String solve(String input) {
        // parse
        String[] s = input.split("\n");
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= Integer.parseInt(s[0]); i++) {

            // execute each deque operation in list sequentially & write to result.
            if (s[i].length() != 1) {
                push(s[i]);

            } else {
                switch (s[i]) {
                    case "3": result.append(pollFirst()); break;
                    case "4": result.append(pollLast()); break;
                    case "5": result.append(size()); break;
                    case "6": result.append(isEmpty()); break;
                    case "7": result.append(peekFirst()); break;
                    case "8": result.append(peekLast()); break;
                }
                result.append("\n");
            }
        }

        // return result
        return result.deleteCharAt(result.length() - 1).toString();
    }

    private void push(String s) {
        String[] ss = s.split(" ");
        int operation = Integer.parseInt(ss[0]);
        int x = Integer.parseInt(ss[1]);
        if (operation == 1) {
            pushFirst(x);
        } else if (operation == 2) {
            pushLast(x);
        }
    }

    // implement each deque operation
    private void pushFirst(int i) {
        deque.add(0, i);
    }

    private void pushLast(int i) {
        deque.add(deque.size(), i);
    }

    private int pollFirst() {
        return deque.isEmpty() ? -1 : deque.remove(0);
    }

    private int pollLast() {
        return deque.isEmpty() ? -1 : deque.remove(deque.size() - 1);
    }

    private int size() {
        return deque.size();
    }

    private int isEmpty() {
        return deque.isEmpty() ? 1 : 0;
    }

    private int peekFirst() {
        return deque.isEmpty() ? -1 : deque.get(0);
    }

    private int peekLast() {
        return deque.isEmpty() ? -1 : deque.get(deque.size() - 1);
    }

}
