package org.alan.algorithm.practice.baekjoon.tagged.sqdl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11003Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        12 3
                        1 5 2 3 6 2 3 7 3 5 2 6""", "1 1 1 2 2 2 2 2 3 3 2 2")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ11003(input).solve());
    }

}
