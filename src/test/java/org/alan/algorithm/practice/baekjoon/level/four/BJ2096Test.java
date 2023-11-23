package org.alan.algorithm.practice.baekjoon.level.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2096Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3\n" +
                        "1 2 3\n" +
                        "4 5 6\n" +
                        "4 9 0", "18 6"),
                Arguments.of("3\n" +
                        "0 0 0\n" +
                        "0 0 0\n" +
                        "0 0 0", "0 0")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ2096 instance = new BJ2096();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
