package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ15681Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        9 5 3
                        1 3
                        4 3
                        5 4
                        5 6
                        6 7
                        2 3
                        9 6
                        6 8
                        5
                        4
                        8""", """
                        9
                        4
                        1""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ15681().solve(input));
    }
}
