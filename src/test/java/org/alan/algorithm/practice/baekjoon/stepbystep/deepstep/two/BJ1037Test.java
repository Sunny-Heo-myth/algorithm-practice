package org.alan.algorithm.practice.baekjoon.stepbystep.deepstep.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1037Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2\n" + "4 2", "8")
                , Arguments.of("1\n" + "2", "4")
                , Arguments.of("6\n" + "3 4 2 12 6 8", "24")
                , Arguments.of("14\n" + "14 26456 2 28 13228 3307 7 23149 8 6614 46298 56 4 92596", "185192")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1037 instance = new BJ1037();
        Assertions.assertEquals(expected, instance.solve2(input));
    }
}
