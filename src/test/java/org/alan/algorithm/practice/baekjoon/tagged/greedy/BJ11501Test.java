package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BJ11501Test {

    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        3
                        10 7 6""", "0"),
                Arguments.of("""
                        3
                        3 5 9""", "10"),
                Arguments.of("""
                        5
                        1 1 3 1 2""", "5"),
                Arguments.of("""
                        9
                        1 0 2 0 5 7 11 2 7""", "56"),
                Arguments.of("""
                        9
                        3 2 1 2 3 2 1 2 3""", "8"),
                Arguments.of("""
                        10
                        3 2 1 2 3 2 1 2 3 4""", "17"),
                Arguments.of("""
                        9
                        7 8 9 1 4 7 2 4 6""", "18")
        );
    }
    
    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ11501(input).solve());
    }
}