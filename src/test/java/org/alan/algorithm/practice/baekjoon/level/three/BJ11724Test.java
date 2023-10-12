package org.alan.algorithm.practice.baekjoon.level.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11724Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("6 5\n" +
                        "1 2\n" +
                        "2 5\n" +
                        "5 1\n" +
                        "3 4\n" +
                        "4 6", "2"),
                Arguments.of("6 8\n" +
                        "1 2\n" +
                        "2 5\n" +
                        "5 1\n" +
                        "3 4\n" +
                        "4 6\n" +
                        "5 4\n" +
                        "2 4\n" +
                        "2 3", "1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ11724 instance = new BJ11724();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
