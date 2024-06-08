package org.alan.algorithm.practice.baekjoon.tagged.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1013Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1", "NO"),
                Arguments.of("100", "NO"),
                Arguments.of("10000", "NO"),
                Arguments.of("10000111001", "YES"),
                Arguments.of("100001111", "YES"),
                Arguments.of("0", "NO"),
                Arguments.of("01", "YES"),
                Arguments.of("10010111", "NO"),
                Arguments.of("011000100110001", "NO"),
                Arguments.of("0110001011001", "YES"),
                Arguments.of("01100010110010110001011001", "YES"),
                Arguments.of("0110001011001101100010110011", "YES"),
                Arguments.of("0110001011000", "NO"),
                Arguments.of("0110001011000", "NO")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1013().solve(input));
    }
}
