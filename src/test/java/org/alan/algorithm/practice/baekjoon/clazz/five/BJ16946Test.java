package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ16946Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3 3
                        101
                        010
                        101""", """
                        303
                        050
                        303"""),
                Arguments.of("""
                        4 5
                        11001
                        00111
                        01010
                        10101""", """
                        46003
                        00732
                        06040
                        50403""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ16946().solve(input));
    }
}
