package org.alan.algorithm.practice.baekjoon.clazz.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ9935Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("mirkovC4nizCC44\n" +
                        "C4", "mirkovniz"),
                Arguments.of("12ab112ab2ab\n" +
                        "12ab", "FRULA"),
                Arguments.of("1\n" +
                        "1", "FRULA"),
                Arguments.of("1\n" +
                        "0", "1"),
                Arguments.of("11111\n" +
                        "11", "1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ9935 instance = new BJ9935();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
