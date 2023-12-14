package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ9375Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3\n" +
                        "hat headgear\n" +
                        "sunglasses eyewear\n" +
                        "turban headgear", "5"),
                Arguments.of("3\n" +
                        "mask face\n" +
                        "sunglasses face\n" +
                        "makeup face", "3")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ9375 instance = new BJ9375();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
