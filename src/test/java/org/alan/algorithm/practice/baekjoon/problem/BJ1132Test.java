package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1132Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        2
                        ABC
                        BCA""", "1875"),
                Arguments.of("""
                        1
                        ABCDEFGHIJ""", "9876543210"),
                Arguments.of("""
                        2
                        ABCDEFGHIJ
                        J""", "9876543202"),
                Arguments.of("""
                        10
                        A
                        BB
                        CCC
                        DDDD
                        EEEEE
                        FFFFFF
                        GGGGGGG
                        HHHHHHHH
                        IIIIIIIII
                        AJJJJJJJJJ""", "9973936905"),
                Arguments.of("""
                        5
                        GHJIDDD
                        AHHCCCA
                        IIJCEJ
                        F
                        HDBIGFJAAJ""", "9888114550")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1132().solve(input));
    }
}
