package org.alan.algorithm.practice.baekjoon.bronze.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ9093Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("I am happy today", "I ma yppah yadot"),
                Arguments.of("We want to win the first prize", "eW tnaw ot niw eht tsrif ezirp")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ9093().solve(input));
    }
}
