package org.alan.algorithm.practice.baekjoon.silver.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2343Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        9 3
                        1 2 3 4 5 6 7 8 9""", "17")
                , Arguments.of("""
                        10 2
                        1 2 3 4 5 6 7 8 9 10000""", "10000")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2343().solve(input));
    }
}
