package org.alan.algorithm.practice.baekjoon.clazz.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10828Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("14\n" +
                        "push 1\n" +
                        "push 2\n" +
                        "top\n" +
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
                        "top", "2\n" +
                        "2\n" +
                        "0\n" +
                        "2\n" +
                        "1\n" +
                        "-1\n" +
                        "0\n" +
                        "1\n" +
                        "-1\n" +
                        "0\n" +
                        "3")
                , Arguments.of("7\n" +
                        "pop\n" +
                        "top\n" +
                        "push 123\n" +
                        "top\n" +
                        "pop\n" +
                        "top\n" +
                        "pop", "-1\n" +
                        "-1\n" +
                        "123\n" +
                        "123\n" +
                        "-1\n" +
                        "-1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ10828 instance = new BJ10828();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
