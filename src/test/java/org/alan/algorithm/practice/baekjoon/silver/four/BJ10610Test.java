package org.alan.algorithm.practice.baekjoon.silver.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10610Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("30", "30"),
                Arguments.of("102", "210"),
                Arguments.of("2931", "-1"),
                Arguments.of("80875542", "88755420")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ10610().solve(input));
    }
}
