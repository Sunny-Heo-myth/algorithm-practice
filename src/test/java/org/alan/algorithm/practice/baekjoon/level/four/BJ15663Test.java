package org.alan.algorithm.practice.baekjoon.level.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ15663Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3 1\n" +
                        "4 4 2",
                        "2\n" +
                        "4"),
                Arguments.of("4 2\n" +
                        "9 7 9 1",
                        "1 7\n" +
                        "1 9\n" +
                        "7 1\n" +
                        "7 9\n" +
                        "9 1\n" +
                        "9 7\n" +
                        "9 9")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ15663 instance = new BJ15663();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
