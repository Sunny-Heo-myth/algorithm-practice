package org.alan.algorithm.practice.baekjoon.barkingdog.sqdl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ30014Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3
                        2 3 5""", """
                        31
                        5 2 3"""),
                Arguments.of("""
                        3
                        1000 1000 1000""", """
                        3000000
                        1000 1000 1000"""),
                Arguments.of("""
                        214
                        1 2 4 8 16""", """
                        5
                        16 4 1 2 8"""),
                Arguments.of("""
                        5
                        1 2 3 4 5""", """
                        48
                        5 3 1 2 4""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ30014().solve(input));
    }
}
