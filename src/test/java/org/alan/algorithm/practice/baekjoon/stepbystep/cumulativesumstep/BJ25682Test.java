package org.alan.algorithm.practice.baekjoon.stepbystep.cumulativesumstep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ25682Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4 4 3
                        BBBB
                        BBBB
                        BBBW
                        BBWB""", "2"),
                Arguments.of("""
                        8 8 8
                        WBWBWBWB
                        BWBWBWBW
                        WBWBWBWB
                        BWBBBWBW
                        WBWBWBWB
                        BWBWBWBW
                        WBWBWBWB
                        BWBWBWBW""", "1"),
                Arguments.of("""
                        10 13 10
                        BBBBBBBBWBWBW
                        BBBBBBBBBWBWB
                        BBBBBBBBWBWBW
                        BBBBBBBBBWBWB
                        BBBBBBBBWBWBW
                        BBBBBBBBBWBWB
                        BBBBBBBBWBWBW
                        BBBBBBBBBWBWB
                        WWWWWWWWWWBWB
                        WWWWWWWWWWBWB""", "30"),
                Arguments.of("""
                        9 23 9
                        BBBBBBBBBBBBBBBBBBBBBBB
                        BBBBBBBBBBBBBBBBBBBBBBB
                        BBBBBBBBBBBBBBBBBBBBBBB
                        BBBBBBBBBBBBBBBBBBBBBBB
                        BBBBBBBBBBBBBBBBBBBBBBB
                        BBBBBBBBBBBBBBBBBBBBBBB
                        BBBBBBBBBBBBBBBBBBBBBBB
                        BBBBBBBBBBBBBBBBBBBBBBB
                        BBBBBBBBBBBBBBBWWWWWWWW""", "40")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ25682().solve(input));
    }
}
