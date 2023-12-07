package org.alan.algorithm.practice.baekjoon.clazz.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11725Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("7\n" +
                        "1 6\n" +
                        "6 3\n" +
                        "3 5\n" +
                        "4 1\n" +
                        "2 4\n" +
                        "4 7", "4\n" +
                        "6\n" +
                        "1\n" +
                        "3\n" +
                        "1\n" +
                        "4"),
                Arguments.of("12\n" +
                        "1 2\n" +
                        "1 3\n" +
                        "2 4\n" +
                        "3 5\n" +
                        "3 6\n" +
                        "4 7\n" +
                        "4 8\n" +
                        "5 9\n" +
                        "5 10\n" +
                        "6 11\n" +
                        "6 12", "1\n" +
                        "1\n" +
                        "2\n" +
                        "3\n" +
                        "3\n" +
                        "4\n" +
                        "4\n" +
                        "5\n" +
                        "5\n" +
                        "6\n" +
                        "6")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ11725 instance = new BJ11725();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
