package org.alan.algorithm.practice.baekjoon.barkingdog.sqdl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ32293Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1
                        A""", "A"),
                Arguments.of("""
                        1
                        B""", "B"),
                Arguments.of("""
                        2
                        AB""", "AB"),
                Arguments.of("""
                        3
                        ABA""", "ABA"),
                Arguments.of("""
                        3
                        BBA""", "BBA"),
                Arguments.of("""
                        3
                        ABB""", "BA"),
                Arguments.of("""
                        9
                        ABABABBBB""", "BAABA"),
                Arguments.of("""
                        12
                        AAAAAABBBBBB""", "AAAABABA")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ32293().solve(input));
    }
}
