package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1697Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5 17", "4"),
                Arguments.of("0 15", "6"),
                Arguments.of("0 16", "5"),
                Arguments.of("0 65536", "17")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1697 instance = new BJ1697();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
