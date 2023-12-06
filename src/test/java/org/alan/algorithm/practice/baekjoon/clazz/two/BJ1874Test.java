package org.alan.algorithm.practice.baekjoon.clazz.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1874Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("8\n" +
                        "4\n" +
                        "3\n" +
                        "6\n" +
                        "8\n" +
                        "7\n" +
                        "5\n" +
                        "2\n" +
                        "1",
                        "+\n" +
                        "+\n" +
                        "+\n" +
                        "+\n" +
                        "-\n" +
                        "-\n" +
                        "+\n" +
                        "+\n" +
                        "-\n" +
                        "+\n" +
                        "+\n" +
                        "-\n" +
                        "-\n" +
                        "-\n" +
                        "-\n" +
                        "-\n"),
                Arguments.of("5\n" +
                        "1\n" +
                        "2\n" +
                        "5\n" +
                        "3\n" +
                        "4",
                        "NO")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1874 instance = new BJ1874();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
