package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BJ5086Test {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("factor", "8 16"),
                Arguments.of("multiple", "32 4"),
                Arguments.of("neither", "17 5")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String expected, String input) {
        BJ5086 instance = new BJ5086();
        assertEquals(expected, instance.solve(input));
    }
    
}

