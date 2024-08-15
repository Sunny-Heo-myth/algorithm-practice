package org.alan.algorithm.practice.baekjoon.stepbystep.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ27433Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("10", "3628800")
                , Arguments.of("0", "1")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ27433 instance = new BJ27433();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
