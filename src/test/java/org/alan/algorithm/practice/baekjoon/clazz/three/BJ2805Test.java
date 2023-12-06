package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2805Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("4 7\n" +
                        "20 15 10 17", "15"),
                Arguments.of("5 20\n" +
                        "4 42 40 26 46", "36"),
                Arguments.of("5 5\n" +
                        "100 100 100 100 100", "99"),
                Arguments.of("5 10\n" +
                        "100 100 100 100 100", "98")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ2805 instance = new BJ2805();
        Assertions.assertEquals(expected, instance.solve2(input));
    }
}
