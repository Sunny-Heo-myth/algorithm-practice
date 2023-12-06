package org.alan.algorithm.practice.baekjoon.clazz.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2475Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("0 4 2 5 6", "1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ2475 instance = new BJ2475();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
