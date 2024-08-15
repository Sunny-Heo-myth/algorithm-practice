package org.alan.algorithm.practice.baekjoon.stepbystep.rectangletriangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BJ9063Test {

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        "3\n" +
                                "20 24\n" +
                                "40 21\n" +
                                "10 12", "360"),
                Arguments.of("1\n" +
                        "15 13", "0"),
                Arguments.of("4\n" +
                        "2 1\n" +
                        "3 2\n" +
                        "5 2\n" +
                        "3 4", "9")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ9063 instance = new BJ9063();
        Assertions.assertEquals(expected, instance.solve(input));
    }

}