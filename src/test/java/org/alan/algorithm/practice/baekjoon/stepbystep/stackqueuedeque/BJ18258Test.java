package org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedeque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ18258Test {
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
                        "3")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ18258 instance = new BJ18258();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
