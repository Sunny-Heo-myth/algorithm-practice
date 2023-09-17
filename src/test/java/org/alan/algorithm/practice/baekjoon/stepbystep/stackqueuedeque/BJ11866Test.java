package org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedeque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11866Test {
    
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("7 3", "<3, 6, 2, 7, 5, 1, 4>")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ11866 instance = new BJ11866();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
