package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime.two;

import org.alan.algorithm.practice.ExecutionTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ17103Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("6", "1"),
                Arguments.of("8", "1"),
                Arguments.of("10", "2"),
                Arguments.of("12", "1"),
                Arguments.of("100", "6")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    @ExecutionTime
    public void test1(String input, String expected) {
        BJ17103 instance = new BJ17103();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
