package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprimestep.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ4134Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("6", "7"),
                Arguments.of("20", "23"),
                Arguments.of("100", "101"),
                Arguments.of("101", "101"),
                Arguments.of("1000000001", "1000000007")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ4134 instance = new BJ4134();
        Assertions.assertEquals(expected, instance.solve1(input));
    }
}
