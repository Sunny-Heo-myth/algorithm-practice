package org.alan.algorithm.practice.baekjoon.tagged.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2302Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        9
                        2
                        4
                        7""", "12")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2302(input).solve());
    }
}
