package org.alan.algorithm.practice.baekjoon.stepbystep.combinatorics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ24723Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1", "2")
                , Arguments.of("2", "4")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ24723 instance = new BJ24723();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
