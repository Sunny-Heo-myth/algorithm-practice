package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprimestep.one;


import org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprimestep.BJ2501;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BJ2501Test {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3", "6 3"),
                Arguments.of("0", "25 4"),
                Arguments.of("1", "2735 1"),
                Arguments.of("9", "81 3"),
                Arguments.of("1", "1 1"),
                Arguments.of("0", "1 2")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String expected, String input) {
        BJ2501 instance = new BJ2501();
        assertEquals(expected, instance.solve(input));
    }
    
}

