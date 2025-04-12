package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1525Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        1 0 3
                        4 2 5
                        7 8 6""", "3"),
                Arguments.of("""
                        3 6 0
                        8 1 2
                        7 4 5""", "-1")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1525(input).solve());
    }
}
