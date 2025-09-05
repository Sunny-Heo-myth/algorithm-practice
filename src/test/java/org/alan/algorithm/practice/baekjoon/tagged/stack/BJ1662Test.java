package org.alan.algorithm.practice.baekjoon.tagged.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BJ1662Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("33(562(71(9)))", "19"),
                Arguments.of("123", "3"),
                Arguments.of("10342(76)", "8"),
                Arguments.of("0(0)", "0"),
                Arguments.of("1(1(1(1(1(1(1(0(1234567890))))))))", "0"),
                Arguments.of("1()66(5)", "7")
        );
    }
    
    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1662(input).solve());
    }
}