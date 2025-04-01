package org.alan.algorithm.practice.baekjoon.stepbystep.forfor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ25304Test {

    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        260000
                        4
                        20000 5
                        30000 2
                        10000 6
                        5000 8""", "Yes"),
                Arguments.of("""
                        250000
                        4
                        20000 5
                        30000 2
                        10000 6
                        5000 8""", "No")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ25304(input).solve());
    }

}
