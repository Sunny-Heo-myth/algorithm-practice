package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1202Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
//                Arguments.of("""
//                        2 1
//                        5 10
//                        100 100
//                        11""", "10"),
                Arguments.of("""
                        3 2
                        1 65
                        5 23
                        2 99
                        10
                        2""", "164"),
                Arguments.of("""
                        4 3
                        1 2
                        2 3
                        3 4
                        4 5
                        2
                        2
                        2""", "5"),
                Arguments.of("""
                        4 3
                        1 2
                        2 3
                        3 4
                        4 5
                        3
                        3
                        3""", "9")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1202().solve(input));
    }
}
