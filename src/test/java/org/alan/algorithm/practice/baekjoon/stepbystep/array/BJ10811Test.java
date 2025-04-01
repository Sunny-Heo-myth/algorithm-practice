package org.alan.algorithm.practice.baekjoon.stepbystep.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10811Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                5 4
                1 2
                3 4
                1 4
                2 2""", "3 4 1 2 5")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ10811(input).solve());
    }

}
