package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1063Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        A1 A2 5
                        B
                        L
                        LB
                        RB
                        LT""", """
                        A1
                        A2"""),
                Arguments.of("""
                        A1 H8 1
                        T""", """
                        A2
                        H8"""),
                Arguments.of("""
                        A1 A2 1
                        T""", """
                        A2
                        A3"""),
                Arguments.of("""
                        A1 A2 2
                        T
                        R""", """
                        B2
                        A3"""),
                Arguments.of("""
                        A8 B7 18
                        RB
                        RB
                        RB
                        RB
                        RB
                        RB
                        RB
                        RB
                        RB
                        RB
                        RB
                        RB
                        RB
                        RB
                        RB
                        RB
                        RB
                        RB""", """
                        G2
                        H1"""),
                Arguments.of("""
                        C1 B1 3
                        L
                        T
                        LB""", """
                        B2
                        A1""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1063().solve(input));
    }
}
