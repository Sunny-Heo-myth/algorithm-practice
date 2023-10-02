package org.alan.algorithm.practice.baekjoon.stepbystep.dynamicprogrammingstep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ24416Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5", "5 3")
                , Arguments.of("30", "832040 28")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ24416 instance = new BJ24416();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
