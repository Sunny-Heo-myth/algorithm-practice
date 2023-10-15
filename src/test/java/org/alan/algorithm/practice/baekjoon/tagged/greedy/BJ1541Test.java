package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1541Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("55-50+40", "-35"),
                Arguments.of("10+20+30+40", "100"),
                Arguments.of("00009-00009", "0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1541 instance = new BJ1541();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
