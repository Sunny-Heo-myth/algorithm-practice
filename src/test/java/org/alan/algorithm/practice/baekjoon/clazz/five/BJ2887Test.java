package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2887Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5
                        11 -15 -15
                        14 -5 -15
                        -1 -1 -5
                        10 -4 -1
                        19 -4 19""", "4")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {

    }
}
