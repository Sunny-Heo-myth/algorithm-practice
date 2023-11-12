package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1015Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3\n" +
                        "2 3 1", "1 2 0"),
                Arguments.of("4\n" +
                        "2 1 3 1", "2 0 3 1"),
                Arguments.of("8\n" +
                        "4 1 6 1 3 6 1 4", "4 0 6 1 3 7 2 5")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1015 instance = new BJ1015();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
