package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1107Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5457\n" +
                        "3\n" +
                        "6 7 8", "6"),
                Arguments.of("100\n" +
                        "5\n" +
                        "0 1 2 3 4", "0"),
                Arguments.of("100\n" +
                        "3\n" +
                        "1 0 5", "0"),
                Arguments.of("500000\n" +
                        "8\n" +
                        "0 2 3 4 6 7 8 9", "11117"),
                Arguments.of("14124\n" +
                        "0", "5"),
                Arguments.of("1\n" +
                        "9\n" +
                        "1 2 3 4 5 6 7 8 9", "2"),
                Arguments.of("80000\n" +
                        "2\n" +
                        "8 9", "2228")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1107 instance = new BJ1107();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
