package org.alan.algorithm.practice.baekjoon.stepbystep.math.one;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BJ2720Test {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("4 2 0 4", "124"),
                Arguments.of("1 0 0 0", "25"),
                Arguments.of("7 1 1 4", "194")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String expected, String input) {
        BJ2720 instance = new BJ2720();
        assertEquals(expected, instance.solve(input));
    }
    
}
