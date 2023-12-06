package org.alan.algorithm.practice.baekjoon.clazz.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1259Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("121", "yes"),
                Arguments.of("1231", "no"),
                Arguments.of("12421", "yes")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1259 instance = new BJ1259();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
