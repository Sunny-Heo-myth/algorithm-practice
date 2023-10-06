package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10845Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("15\n" +
                        "push 1\n" +
                        "push 2\n" +
                        "front\n" +
                        "back\n" +
                        "size\n" +
                        "empty\n" +
                        "pop\n" +
                        "pop\n" +
                        "pop\n" +
                        "size\n" +
                        "empty\n" +
                        "pop\n" +
                        "push 3\n" +
                        "empty\n" +
                        "front", "1\n" +
                        "2\n" +
                        "2\n" +
                        "0\n" +
                        "1\n" +
                        "2\n" +
                        "-1\n" +
                        "0\n" +
                        "1\n" +
                        "-1\n" +
                        "0\n" +
                        "3"),
                Arguments.of("10\n" +
                        "push 1\n" +
                        "push 2\n" +
                        "push 2\n" +
                        "push 2\n" +
                        "push 2\n" +
                        "push 2\n" +
                        "pop\n" +
                        "pop\n" +
                        "pop\n" +
                        "push 2",
                        "1\n" +
                        "2\n" +
                        "2")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ10845 instance = new BJ10845();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
