package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1934Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3\n" +
                        "1 45000\n" +
                        "6 10\n" +
                        "13 17", "45000\n" +
                        "30\n" +
                        "221"),
                Arguments.of("1\n" +
                        "44999 45000\n",
                        "2024955000")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1934 instance = new BJ1934();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
