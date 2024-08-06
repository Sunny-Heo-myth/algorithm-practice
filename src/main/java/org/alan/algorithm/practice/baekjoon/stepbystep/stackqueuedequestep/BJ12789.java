package org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedequestep;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class BJ12789 {
    public String solve(String input) {
        // parse
        String[] s = input.split("\n");

        // initiate line Queue and fill it
        Queue<Integer> line = Arrays.stream(s[1].split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));

        // initiate wait stack
        Stack<Integer> wait = new Stack<>();

        // initiate receiveNumber as 1
        int receiveNumber = 1;

        while (!line.isEmpty()) {
            // poll line
            int person = line.peek();

            // if it is same with receiveNumber increment receiveNumber & continue
            if (person == receiveNumber) {
                line.poll();
                receiveNumber++;
                continue;
            }

            // if it is same with the top of waitStack pop it & continue
            if (!wait.isEmpty() && wait.peek() == receiveNumber) {
                wait.pop();
                receiveNumber++;
                continue;
            }

            // add person to waitStack
            wait.push(line.poll());
        }

        // while waitStack is not empty
        while (!wait.isEmpty()) {
            // if wait pop is same with receiveNumber increment receiveNumber & continue
            if (wait.pop() == receiveNumber) {
                receiveNumber++;
            } else {
                return "Sad";
            }
        }

        // return Nice
        return "Nice";
    }
}
