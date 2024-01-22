package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1644Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("20", "0"),
                Arguments.of("3", "1"),
                Arguments.of("41", "3"),
                Arguments.of("53", "2"),
                Arguments.of("1", "0"),
                Arguments.of("4000000", "1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1644().solve(input));
    }
}
