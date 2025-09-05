package org.alan.algorithm.practice.baekjoon.tagged.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BJ11051Test {
    
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("1 0", "1"),
                Arguments.of("2 0", "1"),
                Arguments.of("1 1", "1"),
                Arguments.of("2 2", "1"),
                Arguments.of("2 1", "2"),
                Arguments.of("3 1", "3"),
                Arguments.of("3 2", "3"),
                Arguments.of("5 2", "10")
        );
    }
    
    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ11051(input).solve());
    }

}