package org.alan.algorithm.practice.baekjoon.tagged.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11758Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1 1\n" +
                        "5 5\n" +
                        "7 3", "-1"),
                Arguments.of("1 1\n" +
                        "3 3\n" +
                        "5 5", "0"),
                Arguments.of("1 1\n" +
                        "7 3\n" +
                        "5 5", "1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ11758 instance = new BJ11758();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
