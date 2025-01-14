package org.alan.algorithm.practice.baekjoon.barkingdog.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1406Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        abcd
                        3
                        P x
                        L
                        P y""", "abcdyx"),
                Arguments.of("""
                        abc
                        9
                        L
                        L
                        L
                        L
                        L
                        P x
                        L
                        B
                        P y""", "yxabc"),
                Arguments.of("""
                        dmih
                        11
                        B
                        B
                        P x
                        L
                        B
                        B
                        B
                        P y
                        D
                        D
                        P z""", "yxz")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1406().solve(input));
    }

}
