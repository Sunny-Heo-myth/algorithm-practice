package org.alan.algorithm.practice.baekjoon.level.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2178Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("4 6\n" +
                        "101111\n" +
                        "101010\n" +
                        "101011\n" +
                        "111011", "15"),
                Arguments.of("4 6\n" +
                        "110110\n" +
                        "110110\n" +
                        "111111\n" +
                        "111101", "9"),
                Arguments.of("2 25\n" +
                        "1011101110111011101110111\n" +
                        "1110111011101110111011101", "38"),
                Arguments.of("7 7\n" +
                        "1011111\n" +
                        "1110001\n" +
                        "1000001\n" +
                        "1000001\n" +
                        "1000001\n" +
                        "1000001\n" +
                        "1111111", "13")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ2178 instance = new BJ2178();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
