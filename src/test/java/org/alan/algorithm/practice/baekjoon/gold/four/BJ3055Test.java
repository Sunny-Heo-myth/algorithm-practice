package org.alan.algorithm.practice.baekjoon.gold.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ3055Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3 3
                        D.*
                        ...
                        .S.""", "3"),
                Arguments.of("""
                        3 3
                        D.*
                        ...
                        ..S""", "KAKTUS"),
                Arguments.of("""
                        3 6
                        D...*.
                        .X.X..
                        ....S.""", "6"),
                Arguments.of("""
                        5 4
                        .D.*
                        ....
                        ..X.
                        S.*.
                        ....""", "4")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ3055().solve(input));
    }
}
