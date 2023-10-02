package org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedequestep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2164Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("6", "4")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ2164 instance = new BJ2164();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
