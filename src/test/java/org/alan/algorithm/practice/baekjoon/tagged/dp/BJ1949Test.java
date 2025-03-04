package org.alan.algorithm.practice.baekjoon.tagged.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1949Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        7
                        1000 3000 4000 1000 2000 2000 7000
                        1 2
                        2 3
                        4 3
                        4 5
                        6 2
                        6 7""", "14000")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1949(input).solve());
    }
}
