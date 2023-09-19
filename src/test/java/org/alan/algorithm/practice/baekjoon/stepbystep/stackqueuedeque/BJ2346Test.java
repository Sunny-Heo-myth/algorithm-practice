package org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedeque;

import org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedequestep.BJ2346;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2346Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5\n" +
                        "3 2 1 -3 -1", "1 4 5 3 2")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ2346 instance = new BJ2346();
        Assertions.assertEquals(expected, instance.solve2(input));
    }
}
