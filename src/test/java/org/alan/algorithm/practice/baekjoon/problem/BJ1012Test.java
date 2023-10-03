package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class BJ1012Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2\n" +
                        "10 8 17\n" +
                        "0 0\n" +
                        "1 0\n" +
                        "1 1\n" +
                        "4 2\n" +
                        "4 3\n" +
                        "4 5\n" +
                        "2 4\n" +
                        "3 4\n" +
                        "7 4\n" +
                        "8 4\n" +
                        "9 4\n" +
                        "7 5\n" +
                        "8 5\n" +
                        "9 5\n" +
                        "7 6\n" +
                        "8 6\n" +
                        "9 6\n" +
                        "10 10 1\n" +
                        "5 5",
                        "5\n" +
                        "1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) throws IOException {
        BJ1012 instance = new BJ1012();
        Assertions.assertEquals(expected, instance.solve());
    }
}
