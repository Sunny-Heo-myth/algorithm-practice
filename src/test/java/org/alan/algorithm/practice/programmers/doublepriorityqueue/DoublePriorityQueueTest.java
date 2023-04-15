package org.alan.algorithm.practice.programmers.doublepriorityqueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DoublePriorityQueueTest {

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}, new int[]{0,0}),
                Arguments.of(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}, new int[]{333, -45})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String[] input, int[] expected) {
        DoublePriorityQueue instance = new DoublePriorityQueue();
        int[] answer = instance.solution(input);
        Assertions.assertEquals(expected[0], answer[0]);
        Assertions.assertEquals(expected[1], answer[1]);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String[] input, int[] expected) {
        DoublePriorityQueue2 instance = new DoublePriorityQueue2();
        int[] answer = instance.solution(input);
        Assertions.assertEquals(expected[0], answer[0]);
        Assertions.assertEquals(expected[1], answer[1]);
    }
}
