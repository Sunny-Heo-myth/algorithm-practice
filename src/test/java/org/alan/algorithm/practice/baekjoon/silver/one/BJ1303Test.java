package org.alan.algorithm.practice.baekjoon.silver.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1303Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5 5
                        WBWWW
                        WWWWW
                        BBBBB
                        BBBWW
                        WWWWW""", "130 65")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1303().solve(input));
    }
}
