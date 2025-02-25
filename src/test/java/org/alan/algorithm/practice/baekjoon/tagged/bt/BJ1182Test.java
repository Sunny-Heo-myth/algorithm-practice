package org.alan.algorithm.practice.baekjoon.tagged.bt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1182Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        5 0
                        -7 -3 -2 5 8""", "1")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1182().solve(input));
    }
}
