package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ30804Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1
                        1""", "1"),
                Arguments.of("""
                        2
                        1 9""", "2"),
                Arguments.of("""
                        2
                        1 9 2""", "2"),
                Arguments.of("""
                        5
                        5 1 1 2 1""", "4"),
                Arguments.of("""
                        3
                        1 1 1""", "3"),
                Arguments.of("""
                        9
                        1 2 3 4 5 6 7 8 9""", "2"),
                Arguments.of("""
                        10
                        1 2 2 2 2 9 2 3 3 1""", "6"),
                Arguments.of("""
                        10
                        1 2 2 2 2 9 2 3 3 1""", "6"),
                Arguments.of("""
                        10
                        1 2 2 2 2 9 2 9 3 1""", "7"),
                Arguments.of("""
                        10
                        2 2 2 2 2 3 2 2 2 3""", "10"),
                Arguments.of("""
                        10
                        1 2 3 4 3 2 1 2 3 2""", "3")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ30804().solve(input));
    }
}
