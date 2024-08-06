package org.alan.algorithm.practice.baekjoon.stepbystep.cumulativesumstep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BJ11659Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        "5 3\n" +
                        "5 4 3 2 1\n" +
                        "1 3\n" +
                        "2 4\n" +
                        "5 5", "12\n" +
                                "9\n" +
                                "1")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ11659 instance = new BJ11659();
        Assertions.assertEquals(expected, instance.solve2(input));
    }

}