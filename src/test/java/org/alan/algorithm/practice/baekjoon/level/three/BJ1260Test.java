package org.alan.algorithm.practice.baekjoon.level.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1260Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        "4 5 1\n" +
                        "1 2\n" +
                        "1 3\n" +
                        "1 4\n" +
                        "2 4\n" +
                        "3 4",
                        "1 2 4 3\n" +
                        "1 2 3 4"),
                Arguments.of(
                        "5 5 3\n" +
                        "5 4\n" +
                        "5 2\n" +
                        "1 2\n" +
                        "3 4\n" +
                        "3 1",
                        "3 1 2 5 4\n" +
                                "3 1 4 2 5"),
                Arguments.of(
                        "1000 1 1000\n" +
                        "999 1000",
                        "1000 999\n" +
                                "1000 999")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1260 instance = new BJ1260();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
