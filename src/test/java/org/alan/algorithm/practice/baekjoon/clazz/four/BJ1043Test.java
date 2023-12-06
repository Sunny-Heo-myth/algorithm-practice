package org.alan.algorithm.practice.baekjoon.clazz.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1043Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("4 3\n" +
                        "0\n" +
                        "2 1 2\n" +
                        "1 3\n" +
                        "3 2 3 4", "3"),
                Arguments.of("4 1\n" +
                        "1 1\n" +
                        "4 1 2 3 4", "0"),
                Arguments.of("4 1\n" +
                        "0\n" +
                        "4 1 2 3 4", "1"),
                Arguments.of("4 5\n" +
                        "1 1\n" +
                        "1 1\n" +
                        "1 2\n" +
                        "1 3\n" +
                        "1 4\n" +
                        "2 4 1", "2"),
                Arguments.of("10 9\n" +
                        "4 1 2 3 4\n" +
                        "2 1 5\n" +
                        "2 2 6\n" +
                        "1 7\n" +
                        "1 8\n" +
                        "2 7 8\n" +
                        "1 9\n" +
                        "1 10\n" +
                        "2 3 10\n" +
                        "1 4", "4")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1043 instance = new BJ1043();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
