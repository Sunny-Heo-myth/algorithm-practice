package org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedeque;

import java.util.Deque;
import java.util.LinkedList;

public class BJ2164 {

    public String solve(String input) {
        int n = Integer.parseInt(input);

        // initiate deque
        Deque<Integer> deque = new LinkedList<>();

        // fill the deque
        for (int i = n; i > 0; i--) {
            deque.addFirst(i);
        }

        // initiate goBack as false
        boolean goBack = false;

        // until there is one int in deque
        while (deque.size() > 1) {
            // if goBack is false
            if (goBack) {
                deque.addLast(deque.pollFirst());
                goBack = false;
            }
            else {
                deque.pollFirst();
                goBack = true;
            }
        }

        // return last element in deque
        return String.valueOf(deque.poll());
    }

}
