package org.alan.algorithm.practice.baekjoon.tagged.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ12738Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        6
                        10 20 10 30 20 50""", "4")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ12738().solve(input));
    }
}
