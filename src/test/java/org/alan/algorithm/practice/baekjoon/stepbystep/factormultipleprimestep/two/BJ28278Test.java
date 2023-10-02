package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprimestep.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ28278Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ28278 instance = new BJ28278();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
