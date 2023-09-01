package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ4134Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3\n" +
                        "6\n" +
                        "20\n" +
                        "100", "7\n" +
                        "23\n" +
                        "101")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ4134 instance = new BJ4134();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
