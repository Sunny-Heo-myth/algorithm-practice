package org.alan.algorithm.practice.baekjoon.barkingdog.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ3273Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        9
                        5 12 7 10 9 1 2 3 11
                        13""", "3")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ3273().solve(input));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ3273().solve2(input));
    }

}
