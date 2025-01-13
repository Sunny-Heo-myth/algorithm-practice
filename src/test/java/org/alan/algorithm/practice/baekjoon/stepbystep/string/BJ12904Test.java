package org.alan.algorithm.practice.baekjoon.stepbystep.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ12904Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        """
                        B
                        ABBA""", "1"),
                Arguments.of("""
                        AB
                        ABB""", "0"),
                Arguments.of("""
                        AAAA
                        AAAAAAAA""", "1"),
                Arguments.of("""
                        BB
                        BBBBB""", "1"),
                Arguments.of("""
                        AA
                        BAA""", "0"),
                Arguments.of("""
                        AB
                        ABAB""", "1"),
                Arguments.of("""
                        ABABAB
                        ABABABABA""", "1"),
                Arguments.of("""
                        ABAA
                        BBAABA""", "0")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ12904().solve(input));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ12904().solve2(input));
    }
}
