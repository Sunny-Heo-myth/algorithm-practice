package org.alan.algorithm.practice.baekjoon.stepbystep.mathstep.one;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BJ2903Test {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("9", "1"),
                Arguments.of("25", "2"),
                Arguments.of("1089", "5")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String expected, String input) {
        BJ2903 instance = new BJ2903();
        assertEquals(expected, instance.solve(input));
    }
    
}

