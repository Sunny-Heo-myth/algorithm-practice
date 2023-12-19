package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ20529Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3\n" +
                        "ENTJ INTP ESFJ", "8"),
                Arguments.of("4\n" +
                        "ESFP ESFP ESFP ESFP", "0"),
                Arguments.of("5\n" +
                        "INFP INFP ESTP ESTJ ISTJ", "4")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ20529().solve(input));
    }
}
