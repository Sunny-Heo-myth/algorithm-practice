package org.alan.algorithm.practice.baekjoon.stepbystep.math1step;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BJ2745Test {
    
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(60466175, "ZZZZZ 36"),
                Arguments.of(0, "0 36")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(int expected, String input) {
        BJ2745 instance = new BJ2745();
        assertEquals(expected, instance.solve(input));
    }

}
