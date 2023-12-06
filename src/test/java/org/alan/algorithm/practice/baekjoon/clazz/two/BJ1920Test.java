package org.alan.algorithm.practice.baekjoon.clazz.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1920Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5\n" +
                        "4 1 5 2 3\n" +
                        "5\n" +
                        "1 3 7 9 5", "1\n" +
                        "1\n" +
                        "0\n" +
                        "0\n" +
                        "1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1920 instance = new BJ1920();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
