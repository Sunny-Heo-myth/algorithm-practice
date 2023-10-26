package org.alan.algorithm.practice.baekjoon.stepbystep.priorityqueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11279Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("13\n" +
                        "0\n" +
                        "1\n" +
                        "2\n" +
                        "0\n" +
                        "0\n" +
                        "3\n" +
                        "2\n" +
                        "1\n" +
                        "0\n" +
                        "0\n" +
                        "0\n" +
                        "0\n" +
                        "0", "0\n" +
                        "2\n" +
                        "1\n" +
                        "3\n" +
                        "2\n" +
                        "1\n" +
                        "0\n" +
                        "0")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ11279 instance = new BJ11279();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
