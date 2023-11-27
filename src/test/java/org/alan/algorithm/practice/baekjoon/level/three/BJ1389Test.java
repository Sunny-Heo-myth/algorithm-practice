package org.alan.algorithm.practice.baekjoon.level.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1389Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5 5\n" +
                        "1 3\n" +
                        "1 4\n" +
                        "4 5\n" +
                        "4 3\n" +
                        "3 2", "3")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1389 instance = new BJ1389();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
