package org.alan.algorithm.practice.baekjoon.clazz.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1167Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2\n" +
                        "1 2 1 -1\n" +
                        "2 1 1 -1\n", "1"),
                Arguments.of("5\n" +
                        "1 3 2 -1\n" +
                        "2 4 4 -1\n" +
                        "3 1 2 4 3 -1\n" +
                        "4 2 4 3 3 5 6 -1\n" +
                        "5 4 6 -1", "11"),
                Arguments.of("6\n" +
                        "1 3 2 -1\n" +
                        "2 4 4 6 7 -1\n" +
                        "3 1 2 4 3 -1\n" +
                        "4 2 4 3 3 5 6 -1\n" +
                        "5 4 6 -1\n" +
                        "6 2 7 -1", "17")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1167 instance = new BJ1167();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
