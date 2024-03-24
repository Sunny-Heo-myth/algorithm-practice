package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1213Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("A", "A"),
                Arguments.of("BBA", "BAB"),
                Arguments.of("AABB", "ABBA"),
                Arguments.of("AAABB", "ABABA"),
                Arguments.of("ABACABA", "AABCBAA"),
                Arguments.of("AABBCC", "ABCCBA"),
                Arguments.of("AABBCCC", "ABCCCBA"),
                Arguments.of("AAABBCC", "ABCACBA"),
                Arguments.of("AABBBCC", "ABCBCBA"),
                Arguments.of("AABBBBC", "ABBCBBA"),
                Arguments.of("AABBBBDD", "ABBDDBBA"),
                Arguments.of("AABBBBBDD", "ABBDBDBBA"),
                Arguments.of("AAABBAAA", "AAABBAAA"),
                Arguments.of("AAAAAC", "I'm Sorry Hansoo"),
                Arguments.of("ABCD", "I'm Sorry Hansoo")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1213().solve(input));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1213().solve2(input));
    }
}
