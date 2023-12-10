package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ6064Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("10 12 3 9", "33"),
                Arguments.of("10 12 7 2", "-1"),
                Arguments.of("13 11 5 6", "83")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ6064 instance = new BJ6064();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
