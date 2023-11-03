package org.alan.algorithm.practice.baekjoon.level.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ18110Test {
    
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5\n" +
                        "1\n" +
                        "5\n" +
                        "5\n" +
                        "7\n" +
                        "8", "6"),
                Arguments.of("10\n" +
                        "1\n" +
                        "13\n" +
                        "12\n" +
                        "15\n" +
                        "3\n" +
                        "16\n" +
                        "13\n" +
                        "12\n" +
                        "14\n" +
                        "15", "13")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ18110 instance = new BJ18110();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
