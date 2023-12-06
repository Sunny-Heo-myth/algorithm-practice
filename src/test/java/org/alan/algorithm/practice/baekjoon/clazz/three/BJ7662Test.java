package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ7662Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("7\n" +
                        "I 16\n" +
                        "I -5643\n" +
                        "D -1\n" +
                        "D 1\n" +
                        "D 1\n" +
                        "I 123\n" +
                        "D -1", "EMPTY"),
                        Arguments.of("9\n" +
                        "I -45\n" +
                        "I 653\n" +
                        "D 1\n" +
                        "I -642\n" +
                        "I 45\n" +
                        "I 97\n" +
                        "D 1\n" +
                        "D -1\n" +
                        "I 333", "333 -45")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ7662 instance = new BJ7662();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
