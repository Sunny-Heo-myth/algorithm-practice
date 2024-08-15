package org.alan.algorithm.practice.baekjoon.bronze.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1264Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        How are you today?
                        Quite well, thank you, how about yourself?
                        I live at number twenty four.
                        #""", """
                        7
                        14
                        9""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1264().solve(input));
    }
}
