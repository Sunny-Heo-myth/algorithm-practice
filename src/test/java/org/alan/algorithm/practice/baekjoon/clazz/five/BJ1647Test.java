package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1647Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        7 12
                        1 2 3
                        1 3 2
                        3 2 1
                        2 5 2
                        3 4 4
                        7 3 6
                        5 1 5
                        1 6 2
                        6 4 1
                        6 5 3
                        4 5 3
                        6 7 4""", "8")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1647().solve(input));
    }
}
