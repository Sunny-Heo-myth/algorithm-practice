package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ13241Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1 1", "1"),
                Arguments.of("3 5", "15"),
                Arguments.of("1 123", "123"),
                Arguments.of("121 199", "24079"),
                Arguments.of("10000000 10000002", "50000010000000")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ13241 instance = new BJ13241();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
