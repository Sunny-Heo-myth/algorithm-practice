package org.alan.algorithm.practice.baekjoon.level.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1676Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("10", "2"),
                Arguments.of("3", "0")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1676 instance = new BJ1676();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
