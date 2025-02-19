package org.alan.algorithm.practice.baekjoon.tagged.sqdl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ15678Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
//                Arguments.of("""
//                        2 2
//                        1 1""", "2"),
//                Arguments.of("""
//                        4 2
//                        1 2 3 4""", "10"),
                Arguments.of("""
                        4 2
                        1 -2 3 4""", "8"),
                Arguments.of("""
                        4 1
                        1 -2 3 4""", "7"),
                Arguments.of("""
                        3 2
                        -4 -2 -7""", "-2"),
                Arguments.of("""
                        10 2
                        2 7 -5 -4 10 -5 -5 -5 30 -10""", "40"),
                Arguments.of("""
                        10 3
                        2 7 -5 -4 10 -5 -5 -5 30 -10""", "44"),
                Arguments.of("""
                        10 3
                        -2 -7 -5 -4 10 -5 -5 -5 30 -10""", "35"),
                Arguments.of("""
                        10 2
                        -2 -7 -5 4 10 -5 -15 -5 30 -10""", "34"),
                Arguments.of("""
                        12 2
                        -2 -7 -5 4 10 -5 -15 -5 30 -40 -50 100""", "100"),
                Arguments.of("""
                        12 3
                        -2 -7 -5 4 10 -5 -15 -5 30 -40 -50 100""", "139")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ15678().solve(input));
    }
}
