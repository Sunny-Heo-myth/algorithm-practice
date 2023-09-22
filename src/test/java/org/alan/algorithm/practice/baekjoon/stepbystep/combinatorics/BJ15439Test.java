package org.alan.algorithm.practice.baekjoon.stepbystep.combinatorics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ15439Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1", "0")
                , Arguments.of("2", "2")
                , Arguments.of("5", "20")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ15439 instance = new BJ15439();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
