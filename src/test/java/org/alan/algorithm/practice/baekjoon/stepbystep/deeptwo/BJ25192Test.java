package org.alan.algorithm.practice.baekjoon.stepbystep.deeptwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ25192Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("9\n" +
                        "ENTER\n" +
                        "pjshwa\n" +
                        "chansol\n" +
                        "chogahui05\n" +
                        "lms0806\n" +
                        "pichulia\n" +
                        "r4pidstart\n" +
                        "swoon\n" +
                        "tony9402", "8")
                , Arguments.of("7\n" +
                        "ENTER\n" +
                        "pjshwa\n" +
                        "chansol\n" +
                        "chogahui05\n" +
                        "ENTER\n" +
                        "pjshwa\n" +
                        "chansol", "5")
                , Arguments.of("3\n" +
                        "ENTER\n" +
                        "lms0806\n" +
                        "lms0806", "1")
                , Arguments.of("ENTER\n" +
                        "ENTER\n" +
                        "ENTER", "0")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ25192 instance = new BJ25192();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
