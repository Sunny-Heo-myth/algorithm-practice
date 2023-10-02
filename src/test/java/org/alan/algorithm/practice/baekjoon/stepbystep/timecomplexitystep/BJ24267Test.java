package org.alan.algorithm.practice.baekjoon.stepbystep.timecomplexitystep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ24267Test {
    
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("7", "35\n" +
                        "3")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ24267 instance = new BJ24267();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
