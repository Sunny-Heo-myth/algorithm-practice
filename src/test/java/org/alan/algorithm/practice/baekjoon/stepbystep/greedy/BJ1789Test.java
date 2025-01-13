package org.alan.algorithm.practice.baekjoon.stepbystep.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1789Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("200", "19"),
                Arguments.of("5", "2"),
                Arguments.of("20", "5"),
                Arguments.of("1", "1"),
                Arguments.of("4294967295", "92681")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1789 instance = new BJ1789();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
