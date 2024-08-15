package org.alan.algorithm.practice.baekjoon.stepbystep.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11729Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1", "1\n" +
                        "1 3"),
                Arguments.of("2", "3\n" +
                        "1 2\n" +
                        "1 3\n" +
                        "2 3"),
                Arguments.of("3", "7\n" +
                        "1 3\n" +
                        "1 2\n" +
                        "3 2\n" +
                        "1 3\n" +
                        "2 1\n" +
                        "2 3\n" +
                        "1 3")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ11729 instance = new BJ11729();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
