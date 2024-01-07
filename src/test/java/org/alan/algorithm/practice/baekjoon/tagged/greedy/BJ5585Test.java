package org.alan.algorithm.practice.baekjoon.topic.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ5585Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("380", "4"),
                Arguments.of("1", "15")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ5585 instance = new BJ5585();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
