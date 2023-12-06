package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ9095Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("4", "7"),
                Arguments.of("7", "44"),
                Arguments.of("10", "274")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ9095 instance = new BJ9095();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
