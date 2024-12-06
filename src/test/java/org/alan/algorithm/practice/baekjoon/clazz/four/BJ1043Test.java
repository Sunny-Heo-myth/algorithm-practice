package org.alan.algorithm.practice.baekjoon.clazz.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1043Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4 3
                        0
                        2 1 2
                        1 3
                        3 2 3 4""", "3"),
                Arguments.of("""
                        4 1
                        1 1
                        4 1 2 3 4""", "0"),
                Arguments.of("""
                        4 1
                        0
                        4 1 2 3 4""", "1"),
                Arguments.of("""
                        4 5
                        1 1
                        1 1
                        1 2
                        1 3
                        1 4
                        2 4 1""", "2"),
                Arguments.of("""
                        10 9
                        4 1 2 3 4
                        2 1 5
                        2 2 6
                        1 7
                        1 8
                        2 7 8
                        1 9
                        1 10
                        2 3 10
                        1 4""", "4")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1043 instance = new BJ1043();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
