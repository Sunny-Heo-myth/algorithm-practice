package org.alan.algorithm.practice.baekjoon.clazz.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1629Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("10 11 12", "4"),
                Arguments.of("1 100000 2", "1"),
                Arguments.of("2 2 2", "0"),
                Arguments.of("100000 1 100001", "100000")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1629 instance = new BJ1629();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
