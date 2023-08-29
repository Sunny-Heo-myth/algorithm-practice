package org.alan.algorithm.practice.baekjoon.stepbystep.bruteforcestep;

import org.alan.algorithm.practice.baekjoon.stepbystep.setandmapstep.BJ19532;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ19532Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1 3 -1 4 1 7", "2 -1"),
                Arguments.of("2 5 8 3 -4 -11", "-1 2")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ19532 instance = new BJ19532();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
