package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11727Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2", "3"),
                Arguments.of("8", "171"),
                Arguments.of("12", "2731")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ11727 instance = new BJ11727();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
