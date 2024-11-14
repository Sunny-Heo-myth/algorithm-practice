package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ15926Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1
                        )""", "0"),
                Arguments.of("""
                        1
                        (""", "0"),
                Arguments.of("""
                        2
                        ()""", "2"),
                Arguments.of("""
                        3
                        (()""", "2"),
                Arguments.of("""
                        2
                        ((""", "0"),
                Arguments.of("""
                        2
                        ))""", "0"),
                Arguments.of("""
                        3
                        )))""", "0"),
                Arguments.of("""
                        3
                        (((""", "0"),
                Arguments.of("""
                        10
                        ))(()())((""", "6"),
                Arguments.of("""
                        5
                        (())(""", "4"),
                Arguments.of("""
                        14
                        (()))()((()))(""", "8"),
                Arguments.of("""
                        14
                        (())(()((())))""", "14"),
                Arguments.of("""
                        20
                        (())(())())((()()()()""", "10"),
                Arguments.of("""
                        21
                        (())(())(())(()()()()""", "12"),
                Arguments.of("""
                        22
                        (())(())(())(()()()(()""", "12")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ15926().solve(input));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ15926().solve2(input));
    }
}
