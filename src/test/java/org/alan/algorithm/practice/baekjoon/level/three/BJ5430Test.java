package org.alan.algorithm.practice.baekjoon.level.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ5430Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("RDD\n" +
                        "4\n" +
                        "[1,2,3,4]",
                        "[2,1]"),
                Arguments.of("DD\n" +
                        "1\n" +
                        "[42]",
                        "error"),
                Arguments.of("RRD\n" +
                        "6\n" +
                        "[1,1,2,3,5,8]",
                        "[1,2,3,5,8]"),
                Arguments.of("D\n" +
                        "0\n" +
                        "[]",
                        "error"),
                Arguments.of("DDRDD\n" +
                        "5\n" +
                        "[1,1,2,3,5]",
                        "[2]"),
                Arguments.of("DDDDR\n" +
                                "5\n" +
                                "[1,1,2,3,5]",
                        "[5]")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ5430 instance = new BJ5430();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
