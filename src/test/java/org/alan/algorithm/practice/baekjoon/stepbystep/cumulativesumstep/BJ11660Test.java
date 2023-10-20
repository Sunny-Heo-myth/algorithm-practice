package org.alan.algorithm.practice.baekjoon.stepbystep.cumulativesumstep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11660Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("4 3\n" +
                        "1 2 3 4\n" +
                        "2 3 4 5\n" +
                        "3 4 5 6\n" +
                        "4 5 6 7\n" +
                        "2 2 3 4\n" +
                        "3 4 3 4\n" +
                        "1 1 4 4", "27\n" +
                        "6\n" +
                        "64")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ11660 instance = new BJ11660();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
