package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprimestep.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ13909Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3", "1"),
                Arguments.of("24", "4"),
                Arguments.of("9", "3"),
                Arguments.of("1", "1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ13909 instance = new BJ13909();
        Assertions.assertEquals(expected, instance.solve2(input));
    }
}
