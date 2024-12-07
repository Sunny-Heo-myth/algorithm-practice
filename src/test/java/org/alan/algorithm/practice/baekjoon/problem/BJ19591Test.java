package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ19591Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3*2+5-5+7", "-1"),
                Arguments.of("123456789", "123456789"),
                Arguments.of("3/2*5-1+2*90", "-176"),
                Arguments.of("-1-1-1-1", "-2"),
                Arguments.of("-001-001-001-0001", "-2"),
                Arguments.of("-010-010-010-0010", "-20"),
                Arguments.of("-13-13/5-6", "0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ19591().solve(input));
    }
}
