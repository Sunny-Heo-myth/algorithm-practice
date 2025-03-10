package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ24479Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        5 5 1
                        1 4
                        1 2
                        2 3
                        2 4
                        3 4""", """
                        1
                        2
                        3
                        4
                        0""")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ24479(input).solve());
    }
}
