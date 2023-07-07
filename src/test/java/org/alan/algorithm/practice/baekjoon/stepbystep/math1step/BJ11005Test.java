package org.alan.algorithm.practice.baekjoon.stepbystep.math1step;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BJ11005Test {

    private static Stream<Arguments> parameters() {
        int three =
                3 * 3 * 3 * 3 * 2 +
                3 * 3 * 3 * 2 +
                        3 * 2 +
                            2;
        return Stream.of(
                Arguments.of("ZZZZZ", "60466175 36"),
                Arguments.of("22022", three + " 3"),
                Arguments.of("0", "0 36"),
                Arguments.of("1", "1 36")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String expected, String input) {
        BJ11005 instance = new BJ11005();
        assertEquals(expected, instance.solve(input));
    }

}

