package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ6593Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3 4 5
                        S....
                        .###.
                        .##..
                        ###.#
                        
                        #####
                        #####
                        ##.##
                        ##...
                        
                        #####
                        #####
                        #.###
                        ####E""", "Escaped in 11 minute(s)."),
                Arguments.of("""
                        1 3 3
                        S##
                        #E#
                        ###""", "Trapped!")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ6593().solve(input));
    }
}
