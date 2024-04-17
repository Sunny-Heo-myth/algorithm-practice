package org.alan.algorithm.practice.baekjoon.silver.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1992Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        8
                        11110000
                        11110000
                        00011100
                        00011100
                        11110000
                        11110000
                        11110011
                        11110011""", "((110(0101))(0010)1(0001))")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1992().solve(input));
    }
}
