package org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedeque;

import org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedequestep.BJ28279;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ28279Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("11\n" +
                        "6\n" +
                        "1 3\n" +
                        "1 8\n" +
                        "7\n" +
                        "8\n" +
                        "3\n" +
                        "2 5\n" +
                        "1 2\n" +
                        "5\n" +
                        "4\n" +
                        "4", "1\n" +
                        "8\n" +
                        "3\n" +
                        "8\n" +
                        "3\n" +
                        "5\n" +
                        "3")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ28279 instance = new BJ28279();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
