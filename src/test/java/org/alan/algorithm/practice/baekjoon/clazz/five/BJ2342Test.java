package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2342Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1 2 2 4 0", "8"),
                Arguments.of("1 1 1 1 1", "7"),
                Arguments.of("1 3 4 1 3", "11")
//                Arguments.of("2 4 1 0 3", "8"),
//                Arguments.of("1 2 2 4 0", "8")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2342().solve(input));
    }
}
