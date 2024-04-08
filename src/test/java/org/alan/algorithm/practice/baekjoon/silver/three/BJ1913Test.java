package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1913Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        7
                        35""", """
                        49 26 27 28 29 30 31
                        48 25 10 11 12 13 32
                        47 24 9 2 3 14 33
                        46 23 8 1 4 15 34
                        45 22 7 6 5 16 35
                        44 21 20 19 18 17 36
                        43 42 41 40 39 38 37
                        5 7""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1913().solve(input));
    }
}
