package org.alan.algorithm.practice.baekjoon.stepbystep.timecomplexitystep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ24262Test {

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1", "1\n" +
                        "0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ24262 instance = new BJ24262();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
