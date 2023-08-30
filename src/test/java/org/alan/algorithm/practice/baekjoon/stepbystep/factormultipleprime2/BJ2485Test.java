package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2485Test {
    
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("4\n" +
                        "1\n" +
                        "3\n" +
                        "7\n" +
                        "13", "3"),
                Arguments.of("4\n" +
                        "5\n" +
                        "7\n" +
                        "8\n" +
                        "13", "5"),

                Arguments.of("3\n" +
                        "999999996\n" +
                        "999999998\n" +
                        "1000000000", "0"),
                Arguments.of("4\n" +
                        "1\n" +
                        "10000\n" +
                        "100000\n" +
                        "1000000000", "111111111")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ2485 instance = new BJ2485();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
