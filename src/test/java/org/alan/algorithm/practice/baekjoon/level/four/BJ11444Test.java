package org.alan.algorithm.practice.baekjoon.level.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11444Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1", "1"),
                Arguments.of("2", "1"),
                Arguments.of("3", "2"),
                Arguments.of("4", "3"),
                Arguments.of("5", "5"),
                Arguments.of("1000", "517691607")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ11444 instance = new BJ11444();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
