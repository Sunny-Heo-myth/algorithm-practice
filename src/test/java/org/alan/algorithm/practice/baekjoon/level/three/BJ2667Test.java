package org.alan.algorithm.practice.baekjoon.level.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2667Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("7\n" +
                        "0110100\n" +
                        "0110101\n" +
                        "1110101\n" +
                        "0000111\n" +
                        "0100000\n" +
                        "0111110\n" +
                        "0111000",
                        "3\n" +
                        "7\n" +
                        "8\n" +
                        "9")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ2667 instance = new BJ2667();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
