package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11286Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("18\n" +
                        "1\n" +
                        "-1\n" +
                        "0\n" +
                        "0\n" +
                        "0\n" +
                        "1\n" +
                        "1\n" +
                        "-1\n" +
                        "-1\n" +
                        "2\n" +
                        "-2\n" +
                        "0\n" +
                        "0\n" +
                        "0\n" +
                        "0\n" +
                        "0\n" +
                        "0\n" +
                        "0", "-1\n" +
                        "1\n" +
                        "0\n" +
                        "-1\n" +
                        "-1\n" +
                        "1\n" +
                        "1\n" +
                        "-2\n" +
                        "2\n" +
                        "0")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ11286().solve(input));
    }

}
