package org.alan.algorithm.practice.baekjoon.stepbystep.rectangletrianglestep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10101Test {
    
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("60\n" +
                        "70\n" +
                        "50", "Scalene"),
                Arguments.of("60\n" +
                        "60\n" +
                        "60", "Equilateral"),
                Arguments.of("70\n" +
                        "70\n" +
                        "40", "Isosceles")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ10101 instance = new BJ10101();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
