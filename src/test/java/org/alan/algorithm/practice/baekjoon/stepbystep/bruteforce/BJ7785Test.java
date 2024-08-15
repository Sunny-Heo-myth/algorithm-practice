package org.alan.algorithm.practice.baekjoon.stepbystep.bruteforce;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ7785Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("4\n" +
                        "Baha enter\n" +
                        "Askar enter\n" +
                        "Baha leave\n" +
                        "Artem enter", "Askar\n" +
                        "Artem")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ7785 instance = new BJ7785();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
