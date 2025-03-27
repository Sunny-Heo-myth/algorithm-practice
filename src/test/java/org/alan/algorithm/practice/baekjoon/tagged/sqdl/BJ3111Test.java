package org.alan.algorithm.practice.baekjoon.tagged.sqdl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ3111Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        n
                        nnnn""", ""),
                Arguments.of("""
                        n
                        nnnnnnonnnnn""", "o"),
                Arguments.of("""
                        ne
                        lukanevolisarmu""", "lukavolisarmu"),
                Arguments.of("""
                        aba
                        ababacccababa""", "bacccab"),
                Arguments.of("""
                        banana
                        babananananadeda""", "deda"),
                Arguments.of("""
                        xoo
                        xxooooxxoooo""", ""),
                Arguments.of("""
                        xoo
                        xxoooooxoxxooooo""", "o"),
                Arguments.of("""
                        xoo
                        oooooooxxxoooooo""", "ooooooo")
        );
    }
    
    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ3111(input).solve());
    }
}
