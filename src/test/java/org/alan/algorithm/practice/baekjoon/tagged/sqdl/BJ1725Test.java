package org.alan.algorithm.practice.baekjoon.tagged.sqdl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1725Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        4
                        2
                        2
                        2
                        2""", "8"),
                Arguments.of("""
                        4
                        1
                        2
                        1
                        5""", "5"),
                Arguments.of("""
                        7
                        2
                        1
                        4
                        5
                        1
                        3
                        3""", "8"),
                Arguments.of("""
                        7
                        2
                        1
                        5
                        5
                        6
                        3
                        2""", "15")
        );
    }
    
//    @ParameterizedTest
//    @MethodSource("test_cases")
//    public void test1(String input, String expected) {
//        Assertions.assertEquals(expected, new BJ1725(input).solve());
//    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1725(input).solve2());
    }

}
