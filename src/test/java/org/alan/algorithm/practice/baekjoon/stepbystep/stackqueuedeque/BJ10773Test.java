package org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedeque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10773Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("4\n" +
                        "3\n" +
                        "0\n" +
                        "4\n" +
                        "0", "0"),
                Arguments.of("10\n" +
                        "1\n" +
                        "3\n" +
                        "5\n" +
                        "4\n" +
                        "0\n" +
                        "0\n" +
                        "7\n" +
                        "0\n" +
                        "0\n" +
                        "6", "7")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ10773 instance = new BJ10773();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
