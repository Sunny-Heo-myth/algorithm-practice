package org.alan.algorithm.practice.baekjoon.stepbystep.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2011Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("0", "0"),
                Arguments.of("1", "1"),
                Arguments.of("12", "2"),
                Arguments.of("18", "2"),
                Arguments.of("20", "1"),
                Arguments.of("26", "2"),
                Arguments.of("27", "1"),
                Arguments.of("30", "0"),
                Arguments.of("34", "1"),
                Arguments.of("123", "3"),
                Arguments.of("234", "2"),
                Arguments.of("1122", "5"),
                Arguments.of("1234", "3"),
                Arguments.of("20114", "3"),
                Arguments.of("30114", "0"),
                Arguments.of("25114", "6"),
                Arguments.of("11111", "8"),
                Arguments.of("1111111111", "89"),
                Arguments.of("1712279212", "18")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2011().solve(input));
    }
}
