package org.alan.algorithm.practice.baekjoon.level.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1927Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("9\n" +
                        "0\n" +
                        "12345678\n" +
                        "1\n" +
                        "2\n" +
                        "0\n" +
                        "0\n" +
                        "0\n" +
                        "0\n" +
                        "32", "0\n" +
                        "1\n" +
                        "2\n" +
                        "12345678\n" +
                        "0")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1927 instance = new BJ1927();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
