package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ9019Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1234 3412", "LL"),
                Arguments.of("1000 1", "L"),
                Arguments.of("1 16", "DDDD")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ9019 instance = new BJ9019();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
