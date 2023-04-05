package org.alan.algorithm.practice.programmers;

import org.alan.algorithm.practice.programmers.doublepriorityqueue.DoublePriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoublePriorityQueueTest {

    @Test
    public void test1() {
        String[] input = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] expected = {0, 0};
        DoublePriorityQueue instance = new DoublePriorityQueue();
        int[] answer = instance.solution(input);
        Assertions.assertEquals(expected[0], answer[0]);
        Assertions.assertEquals(expected[1], answer[1]);
    }

    @Test
    public void test2() {
        String[] input = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] expected = {333, -45};
        DoublePriorityQueue instance = new DoublePriorityQueue();
        int[] answer = instance.solution(input);
        Assertions.assertEquals(expected[0], answer[0]);
        Assertions.assertEquals(expected[1], answer[1]);
    }
}
