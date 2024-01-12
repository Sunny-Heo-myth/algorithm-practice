package org.alan.algorithm.practice.baekjoon.tagged.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ17609Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("abba", "0"),
                Arguments.of("summuus", "1"),
                Arguments.of("xabba", "1"),
                Arguments.of("xabbay", "2"),
                Arguments.of("comcom", "2"),
                Arguments.of("comwwmoc", "0"),
                Arguments.of("comwwtmoc", "1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ17609().solve(input));
    }
}
