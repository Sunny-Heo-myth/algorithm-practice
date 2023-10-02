package org.alan.algorithm.practice.baekjoon.stepbystep.rectangletrianglestep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ5073Test {
    
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("7 7 7\n" +
                        "6 5 4\n" +
                        "3 2 5\n" +
                        "6 2 6\n" +
                        "0 0 0", "Equilateral\n" +
                        "Scalene\n" +
                        "Invalid\n" +
                        "Isosceles")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ5073 instance = new BJ5073();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
