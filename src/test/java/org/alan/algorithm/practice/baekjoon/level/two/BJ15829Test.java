package org.alan.algorithm.practice.baekjoon.level.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ15829Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5\n" +
                        "abcde", "4739715"),
                Arguments.of("3\n" +
                        "zzz", "25818"),
                Arguments.of("1\n" +
                        "i", "9")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ15829 instance = new BJ15829();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
