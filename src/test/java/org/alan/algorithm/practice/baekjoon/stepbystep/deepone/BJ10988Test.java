package org.alan.algorithm.practice.baekjoon.stepbystep.deepone;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BJ10988Test {

    private static Stream<Arguments> test1Parameter() {
        return Stream.of(
                Arguments.of(1, "level")
                , Arguments.of(0, "baekjoon")
        );
    }
    @ParameterizedTest
    @MethodSource("test1Parameter")
    void test1(int expected, String input) {
        BJ10988 instance = new BJ10988();
        int answer = instance.solve(input);
        assertEquals(expected, answer);
    }
}
