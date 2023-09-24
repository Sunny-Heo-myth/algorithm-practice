package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1005Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2\n" +
                        "4 4\n" +
                        "10 1 100 10\n" +
                        "1 2\n" +
                        "1 3\n" +
                        "2 4\n" +
                        "3 4\n" +
                        "4\n" +
                        "8 8\n" +
                        "10 20 1 5 8 7 1 43\n" +
                        "1 2\n" +
                        "1 3\n" +
                        "2 4\n" +
                        "2 5\n" +
                        "3 6\n" +
                        "5 7\n" +
                        "6 7\n" +
                        "7 8\n" +
                        "7", "120\n" +
                        "39")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1005 instance = new BJ1005();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
