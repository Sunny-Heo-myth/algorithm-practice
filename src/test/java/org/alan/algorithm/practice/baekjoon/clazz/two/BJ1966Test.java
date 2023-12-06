package org.alan.algorithm.practice.baekjoon.clazz.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1966Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1 0\n" +
                        "5", "1"),
                Arguments.of("4 2\n" +
                        "1 2 3 4", "2"),
                Arguments.of("6 0\n" +
                        "1 1 9 1 1 1", "5")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1966 instance = new BJ1966();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
