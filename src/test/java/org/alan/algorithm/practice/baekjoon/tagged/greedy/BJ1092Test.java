package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1092Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
//                Arguments.of("""
//                        3
//                        6 8 9
//                        5
//                        2 5 2 4 7""", "2"),
                Arguments.of("""
                        2
                        19 20
                        7
                        14 12 16 19 16 1 5""", "4"),
                Arguments.of("""
                        4
                        23 32 25 28
                        10
                        5 27 10 16 24 20 2 32 18 7""", "3"),
                Arguments.of("""
                        10
                        11 17 5 2 20 7 5 5 20 7
                        5
                        18 18 15 15 17""", "2"),
                Arguments.of("""
                        5
                        10 9 8 7 6
                        10
                        10 10 10 10 10 10 10 10 10 10""", "10")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1092().solve(input));
    }
}
