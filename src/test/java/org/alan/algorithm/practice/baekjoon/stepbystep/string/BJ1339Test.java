package org.alan.algorithm.practice.baekjoon.stepbystep.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1339Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        2
                        AAA
                        AAA""", "1998"),
                Arguments.of("""
                        2
                        GCF
                        ACDEB""", "99437"),
                Arguments.of("""
                        10
                        A
                        B
                        C
                        D
                        E
                        F
                        G
                        H
                        I
                        J""", "45"),
                Arguments.of("""
                        2
                        AB
                        BA""", "187")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1339().solve(input));
    }
}
