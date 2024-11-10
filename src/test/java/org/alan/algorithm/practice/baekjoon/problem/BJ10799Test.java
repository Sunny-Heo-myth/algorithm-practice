package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10799Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("()(((()())(())()))(())", "17"),
                Arguments.of("(((()(()()))(())()))(()())", "24")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ10799().solve(input));
    }
}
