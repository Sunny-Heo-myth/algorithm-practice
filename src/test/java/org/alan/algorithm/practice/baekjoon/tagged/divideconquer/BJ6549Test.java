package org.alan.algorithm.practice.baekjoon.tagged.divideconquer;

import org.alan.algorithm.practice.baekjoon.tagged.divideconquer.BJ6549;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ6549Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("7 2 1 4 5 1 3 3", "8"),
                Arguments.of("4 1000 1000 1000 1000", "4000")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ6549 instance = new BJ6549();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
