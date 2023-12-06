package org.alan.algorithm.practice.baekjoon.clazz.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10866Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("15\n" +
                        "push_back 1\n" +
                        "push_front 2\n" +
                        "front\n" +
                        "back\n" +
                        "size\n" +
                        "empty\n" +
                        "pop_front\n" +
                        "pop_back\n" +
                        "pop_front\n" +
                        "size\n" +
                        "empty\n" +
                        "pop_back\n" +
                        "push_front 3\n" +
                        "empty\n" +
                        "front", "2\n" +
                        "1\n" +
                        "2\n" +
                        "0\n" +
                        "2\n" +
                        "1\n" +
                        "-1\n" +
                        "0\n" +
                        "1\n" +
                        "-1\n" +
                        "0\n" +
                        "3"),
                Arguments.of("22\n" +
                        "front\n" +
                        "back\n" +
                        "pop_front\n" +
                        "pop_back\n" +
                        "push_front 1\n" +
                        "front\n" +
                        "pop_back\n" +
                        "push_back 2\n" +
                        "back\n" +
                        "pop_front\n" +
                        "push_front 10\n" +
                        "push_front 333\n" +
                        "front\n" +
                        "back\n" +
                        "pop_back\n" +
                        "pop_back\n" +
                        "push_back 20\n" +
                        "push_back 1234\n" +
                        "front\n" +
                        "back\n" +
                        "pop_back\n" +
                        "pop_back", "-1\n" +
                        "-1\n" +
                        "-1\n" +
                        "-1\n" +
                        "1\n" +
                        "1\n" +
                        "2\n" +
                        "2\n" +
                        "333\n" +
                        "10\n" +
                        "10\n" +
                        "333\n" +
                        "20\n" +
                        "1234\n" +
                        "1234\n" +
                        "20")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ10866 instance = new BJ10866();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
