package org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedequestep;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BJ24511 {

    public String solve(String input) {
        String[] lines = input.split("\n");

        // D&I queue index collection (only queue)
        int[] zeroOne = getInts(lines, 1);

        int[] numbers = getInts(lines, 2);

        // D&I a queue
        Queue<Integer> queue = new LinkedList<>();

        // if zeroOne is zero fill the queue with reverse index order
        for (int i = zeroOne.length - 1; i >= 0; i--) { // O(n)
            if (zeroOne[i] == 0) {
                queue.offer(numbers[i]);
            }
        }

        int[] waiting = getInts(lines, 4);

        StringBuilder sb = new StringBuilder();

        // push and pop n times
        for (int i : waiting) { // O(n)
            queue.offer(i);
            sb.append(queue.poll()).append(" ");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private int[] getInts(String[] lines, int lineNumber) {
        return Arrays.stream(lines[lineNumber].split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
