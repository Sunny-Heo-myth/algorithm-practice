package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1931Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
//                Arguments.of("11\n" +
//                        "1 4\n" +
//                        "3 5\n" +
//                        "0 6\n" +
//                        "5 7\n" +
//                        "3 8\n" +
//                        "5 9\n" +
//                        "6 10\n" +
//                        "8 11\n" +
//                        "8 12\n" +
//                        "2 13\n" +
//                        "12 14", "4"),
                Arguments.of("13\n" +
                        "3 5\n" +
                        "0 6\n" +
                        "5 7\n" +
                        "3 8\n" +
                        "5 9\n" +
                        "6 10\n" +
                        "3 4\n" +
                        "2 4\n" +
                        "12 14\n" +
                        "1 4\n" +
                        "8 11\n" +
                        "8 12\n" +
                        "2 13\n", "4")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1931 instance = new BJ1931();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
