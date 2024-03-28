package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1051Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3 5
                        42101
                        22100
                        22101""", "9"),
                Arguments.of("""
                        2 2
                        12
                        34""", "1"),
                Arguments.of("""
                        2 4
                        1255
                        3455""", "4"),
                Arguments.of("""
                        1 10
                        1234567890""", "1"),
                Arguments.of("""
                        11 10
                        9785409507
                        2055103694
                        0861396761
                        3073207669
                        1233049493
                        2300248968
                        9769239548
                        7984130001
                        1670020095
                        8894239889
                        4053971072""", "49")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1051().solve(input));
    }
}
