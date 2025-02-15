package org.alan.algorithm.practice.baekjoon.tagged.grd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1700Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        2 7
                        2 3 2 3 1 2 7""", "2"),
                Arguments.of("""
                        3 6
                        1 2 3 4 1 2""", "1")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1700().solve(input));
    }
}
