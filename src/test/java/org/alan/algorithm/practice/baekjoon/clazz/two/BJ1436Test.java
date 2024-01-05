package org.alan.algorithm.practice.baekjoon.clazz.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1436Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2", "1666"),
                Arguments.of("3", "2666"),
                Arguments.of("6", "5666"),
                Arguments.of("187", "66666"),
                Arguments.of("500", "166699")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1436().solve(input));
    }
}
