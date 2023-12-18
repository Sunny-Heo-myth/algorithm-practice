package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ16928Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3 7\n" +
                        "32 62\n" +
                        "42 68\n" +
                        "12 98\n" +
                        "95 13\n" +
                        "97 25\n" +
                        "93 37\n" +
                        "79 27\n" +
                        "75 19\n" +
                        "49 47\n" +
                        "67 17", "3"),
                Arguments.of("4 9\n" +
                        "8 52\n" +
                        "6 80\n" +
                        "26 42\n" +
                        "2 72\n" +
                        "51 19\n" +
                        "39 11\n" +
                        "37 29\n" +
                        "81 3\n" +
                        "59 5\n" +
                        "79 23\n" +
                        "53 7\n" +
                        "43 33\n" +
                        "77 21", "5")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ16928 instance = new BJ16928();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
