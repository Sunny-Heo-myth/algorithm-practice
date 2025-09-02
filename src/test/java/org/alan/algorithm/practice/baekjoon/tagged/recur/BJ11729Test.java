package org.alan.algorithm.practice.baekjoon.tagged.recur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11729Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1", """
                        1
                        1 3"""),
                Arguments.of("2", """
                        3
                        1 2
                        1 3
                        2 3"""),
                Arguments.of("3", """
                        7
                        1 3
                        1 2
                        3 2
                        1 3
                        2 1
                        2 3
                        1 3""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ11729(input).solve());
    }
}
