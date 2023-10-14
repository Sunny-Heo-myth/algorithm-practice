package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11047Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("10 4200\n" +
                        "1\n" +
                        "5\n" +
                        "10\n" +
                        "50\n" +
                        "100\n" +
                        "500\n" +
                        "1000\n" +
                        "5000\n" +
                        "10000\n" +
                        "50000", "6")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ11047 instance = new BJ11047();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
