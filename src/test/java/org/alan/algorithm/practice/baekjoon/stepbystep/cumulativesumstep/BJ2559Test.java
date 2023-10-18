package org.alan.algorithm.practice.baekjoon.stepbystep.cumulativesumstep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2559Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("10 2\n" +
                        "3 -2 -4 -9 0 3 7 13 8 -3", "21"),
                Arguments.of("10 5\n" +
                        "3 -2 -4 -9 0 3 7 13 8 -3", "31")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ2559 instance = new BJ2559();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
