package org.alan.algorithm.practice.baekjoon.stepbystep.timecomplexitystep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ24313Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("7 7\n" +
                        "8\n" +
                        "1", "0"),
                Arguments.of("7 7\n" +
                        "8\n" +
                        "10", "1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ24313 instance = new BJ24313();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
