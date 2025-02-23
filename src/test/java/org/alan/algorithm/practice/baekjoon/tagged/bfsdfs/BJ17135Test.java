package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ17135Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
//                Arguments.of("""
//                        5 5 1
//                        0 0 0 0 0
//                        0 0 0 0 0
//                        0 0 0 0 0
//                        0 0 0 0 0
//                        1 1 1 1 1""", "3"),
//                Arguments.of("""
//                        5 5 1
//                        0 0 0 0 0
//                        0 0 0 0 0
//                        0 0 0 0 0
//                        1 1 1 1 1
//                        0 0 0 0 0""", "3"),
                Arguments.of("""
                        5 5 2
                        0 0 0 0 0
                        0 0 0 0 0
                        0 0 0 0 0
                        1 1 1 1 1
                        0 0 0 0 0""", "5"),
                Arguments.of("""
                        5 5 5
                        1 1 1 1 1
                        1 1 1 1 1
                        1 1 1 1 1
                        1 1 1 1 1
                        1 1 1 1 1""", "15"),
                Arguments.of("""
                        6 5 1
                        1 0 1 0 1
                        0 1 0 1 0
                        1 1 0 0 0
                        0 0 0 1 1
                        1 1 0 1 1
                        0 0 1 0 0""", "9"),
                Arguments.of("""
                        6 5 2
                        1 0 1 0 1
                        0 1 0 1 0
                        1 1 0 0 0
                        0 0 0 1 1
                        1 1 0 1 1
                        0 0 1 0 0""", "14")
        );
    }
    
    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ17135().solve(input));
    }

}
