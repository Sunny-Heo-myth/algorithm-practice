package org.alan.algorithm.practice.baekjoon.bronze;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1924Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1 1", "MON"),
                Arguments.of("3 14", "WED"),
                Arguments.of("9 2", "SUN")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1924().solve(input));
    }
}
