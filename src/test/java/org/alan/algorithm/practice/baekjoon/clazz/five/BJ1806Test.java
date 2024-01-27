package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1806Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        10 15
                        5 1 3 5 10 7 4 9 2 8""", "2"),
                Arguments.of("""
                        10 21
                        5 1 3 5 10 7 4 9 2 8""", "3"),
                Arguments.of("""
                        10 54
                        5 1 3 5 10 7 4 9 2 8""", "10"),
                Arguments.of("""
                        10 55
                        5 1 3 5 10 7 4 9 2 8""", "0")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1806().solve(input));
    }
}
