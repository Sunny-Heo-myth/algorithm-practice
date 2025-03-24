package org.alan.algorithm.practice.baekjoon.tagged.sqdl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ6549Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3 100 50 100", "150"),
                Arguments.of("3 5 2 5", "6"),
                Arguments.of("7 2 1 4 5 1 3 3", "8"),
                Arguments.of("4 1000 1000 1000 1000", "4000"),
                Arguments.of("2 1 3", "3"),
                Arguments.of("4 1 5 1 4", "5"),
                Arguments.of("3 1 5 1", "5"),
                Arguments.of("3 0 1 0", "1"),
                Arguments.of("9 4 6 8 10 10 9 7 5 3", "36"),
                Arguments.of("9 4 6 8 10 0 9 7 5 3", "18"),
                Arguments.of("9 4 6 8 0 10 9 7 5 3", "21"),
                Arguments.of("9 4 6 8 0 10 9 0 5 3", "18"),
                Arguments.of("9 10 10 0 10 10 9 0 5 3", "27")
        );
    }
    
//    @ParameterizedTest
//    @MethodSource("parameters")
//    public void test1(String input, String expected) {
//        Assertions.assertEquals(expected, new BJ6549(input).solve());
//    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ6549(input).solve2());
    }

}
