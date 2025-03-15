package org.alan.algorithm.practice.baekjoon.tagged.bt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1941Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        YYYYY
                        SYSYS
                        YYYYY
                        YSYYS
                        YYYYY""", "2")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1941(input).solve());
    }
}
