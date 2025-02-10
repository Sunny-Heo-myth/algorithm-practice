package org.alan.algorithm.practice.baekjoon.tagged.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2629Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1
                        3
                        2
                        3 6""", "Y N"),
                Arguments.of("""
                        2
                        1 4
                        2
                        3 2 5""", "Y N Y"),
                Arguments.of("""
                        4
                        2 3 3 3
                        3
                        1 4 10""", "Y Y N")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2629().solve(input));
    }
}
