package org.alan.algorithm.practice.baekjoon.tagged.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2352Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        6
                        4 2 6 3 1 5""", "3"),
                Arguments.of("""
                        6
                        1 3 2 4 5 6""", "5")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2352(input).solve());
    }
}
