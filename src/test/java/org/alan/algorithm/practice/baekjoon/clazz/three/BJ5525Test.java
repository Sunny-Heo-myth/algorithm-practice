package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ5525Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1\n" +
                        "13\n" +
                        "OOIOIOIOIIOII", "4"),
                Arguments.of("2\n" +
                        "13\n" +
                        "OOIOIOIOIIOII", "2"),
                Arguments.of("3\n" +
                        "13\n" +
                        "OOIOIOIOIIOII", "1"),
                Arguments.of("1\n" +
                        "24\n" +
                        "OOIOIOIOIIOIIOIOIOIOIOOI", "8"),
                Arguments.of("1\n" +
                        "24\n" +
                        "OOIOIOIOIIOIIOIOIOIOIIOI", "9")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ5525 instance = new BJ5525();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
