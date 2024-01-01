package org.alan.algorithm.practice.baekjoon.tagged.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2744Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("WrongAnswer", "wRONGaNSWER")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2744().solve(input));
    }
}
