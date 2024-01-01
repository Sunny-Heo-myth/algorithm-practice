package org.alan.algorithm.practice.baekjoon.tagged.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1439Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("0001100", "1"),
                Arguments.of("11111", "0"),
                Arguments.of("00000001", "1"),
                Arguments.of("11001100110011000001", "4"),
                Arguments.of("11101101", "2")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1439().solve(input));
    }
}
