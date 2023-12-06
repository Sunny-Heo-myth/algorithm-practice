package org.alan.algorithm.practice.baekjoon.clazz.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2920Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1 2 3 4 5 6 7 8", "ascending"),
                Arguments.of("8 7 6 5 4 3 2 1", "descending"),
                Arguments.of("8 1 7 2 6 3 5 4", "mixed")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ2920 instance = new BJ2920();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
