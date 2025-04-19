package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ8980Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        4 40
                        6
                        3 4 20
                        1 2 10
                        1 3 20
                        1 4 30
                        2 3 10
                        2 4 20""", "70"),
                Arguments.of("""
                        6 60
                        5
                        1 2 30
                        2 5 70
                        5 6 60
                        3 4 40
                        1 6 40""", "150")
        );
    }
    
    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ8980(input).solve());
    }
}
