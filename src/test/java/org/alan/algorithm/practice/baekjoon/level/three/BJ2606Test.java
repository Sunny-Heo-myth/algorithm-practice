package org.alan.algorithm.practice.baekjoon.level.three;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2606Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        "7\n" +
                        "6\n" +
                        "1 2\n" +
                        "2 3\n" +
                        "1 5\n" +
                        "5 2\n" +
                        "5 6\n" +
                        "4 7", "4"),
                Arguments.of(
                        "10\n" +
                        "9\n" +
                        "1 2\n" +
                        "2 3\n" +
                        "2 4\n" +
                        "2 7\n" +
                        "1 5\n" +
                        "5 6\n" +
                        "8 9\n" +
                        "9 10\n" +
                        "4 7", "6"),
                Arguments.of(
                        "1\n" +
                        "0\n", "0"),
                Arguments.of(
                        "2\n" +
                        "1\n" +
                        "1 2", "1"),
                Arguments.of(
                        "100\n" +
                                "3\n" +
                                "1 3\n" +
                                "3 5\n" +
                                "5 7\n"
                        , "3"),
                Arguments.of(
                        "7\n" +
                                "5\n" +
                                "1 7\n" +
                                "2 3\n" +
                                "5 2\n" +
                                "5 6\n" +
                                "4 7", "2"),
                Arguments.of(
                        "7\n" +
                                "9\n" +
                                "1 7\n" +
                                "2 3\n" +
                                "5 2\n" +
                                "5 3\n" +
                                "1 6\n" +
                                "4 7\n" +
                                "1 4\n" +
                                "6 7\n" +
                                "4 6\n", "3")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ2606 instance = new BJ2606();
    }
}
