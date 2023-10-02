package org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedequestep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ12789Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5\n5 4 1 3 2", "Nice"),
                Arguments.of("10\n10 9 8 7 6 5 4 3 2 1", "Nice"),
                Arguments.of("10\n9 10 8 7 6 5 4 3 2 1", "Sad"),
                Arguments.of("10\n1 2 3 4 5 6 7 8 9 10", "Nice"),
                Arguments.of("10\n1 2 3 10 4 5 6 7 8 9", "Nice"),
                Arguments.of("10\n1 2 10 9 7 4 3 5 6 8", "Nice")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ12789 instance = new BJ12789();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
