package org.alan.algorithm.practice.baekjoon.level.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ18111Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3 4 1\n" +
                        "64 64 64 64\n" +
                        "64 64 64 64\n" +
                        "64 64 64 63", "1 64"),
                Arguments.of("3 4 99\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 1", "2 0"),
                Arguments.of("3 4 0\n" +
                        "64 64 64 64\n" +
                        "64 64 64 64\n" +
                        "64 64 64 63", "22 63")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ18111 instance = new BJ18111();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
