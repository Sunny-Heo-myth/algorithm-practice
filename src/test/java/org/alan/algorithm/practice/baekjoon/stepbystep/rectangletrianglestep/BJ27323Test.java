package org.alan.algorithm.practice.baekjoon.stepbystep.rectangletrianglestep;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BJ27323Test {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("100", "1\n100"),
                Arguments.of("6", "2\n3"),
                Arguments.of("16", "4\n4")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String expected, String input) {
        BJ27323 instance = new BJ27323();
        assertEquals(expected, instance.solve(input));
    }
    
}
