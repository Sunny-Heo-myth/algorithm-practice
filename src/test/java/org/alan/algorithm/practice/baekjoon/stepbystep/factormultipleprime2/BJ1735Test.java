package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1735Test {

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2 7\n" +
                        "3 5", "31 35"),
                Arguments.of("4 2\n" +
                        "6 3", "4 1"),
                Arguments.of("30000 29999\n" +
                        "29999 30000", "1799940001 899970000"),
                Arguments.of("1 29999\n" +
                        "1 30000", "59999 899970000"),
                Arguments.of("1 1\n" +
                        "1 1", "2 1"),
                Arguments.of("1 30000\n" +
                        "1 15000", "1 10000")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1735 instance = new BJ1735();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
