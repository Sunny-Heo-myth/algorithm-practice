package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BJ9506Test {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("6 = 1 + 2 + 3", "6"),
                Arguments.of("12 is NOT perfect.", "12"),
                Arguments.of("28 = 1 + 2 + 4 + 7 + 14", "28"),
                Arguments.of("1 is NOT perfect.", "1"),
                Arguments.of("9 is NOT perfect.", "9"),
                Arguments.of("16 is NOT perfect.", "16"),
                Arguments.of("15 is NOT perfect.", "15")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String expected, String input) {
        BJ9506 instance = new BJ9506();
        assertEquals(expected, instance.solve(input));
    }
    
}

