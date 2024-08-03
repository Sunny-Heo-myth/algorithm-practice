package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ16566Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        10 7 5
                        2 5 3 7 8 4 9
                        4 1 1 3 8""", """
                        5
                        2
                        3
                        4
                        9""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ16566().solve(input));
    }
}
