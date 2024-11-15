package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BJ25381Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("A", "0")
                , Arguments.of("ABBC", "2")
                , Arguments.of("BABC", "2")
                , Arguments.of("BACB", "2")
                , Arguments.of("ABCBA", "2")
                , Arguments.of("ABCBBACBABB", "5")
                , Arguments.of("ABABABAB", "4")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ25381().solve(input));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ25381().solve2(input));
    }

}