package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1509Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("BBCDDECAECBDABADDCEBACCCBDCAABDBADD", "22"),
                Arguments.of("AAAA", "1"),
                Arguments.of("ABCDEFGH", "8"),
                Arguments.of("QWERTYTREWQWERT", "5"),
                Arguments.of("QWRRWQ", "1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1509().solve(input));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1509().solve2(input));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test3(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1509().solve3(input));
    }
}
