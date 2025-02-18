package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ3109Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        1 5
                        .xx..""", "0"),
                Arguments.of("""
                        1 5
                        .....""", "1"),
                Arguments.of("""
                        5 5
                        .xx..
                        ..x..
                        .....
                        ...x.
                        ...x.""", "2"),
                Arguments.of("""
                        6 10
                        ..x.......
                        .....x....
                        .x....x...
                        ...x...xx.
                        ..........
                        ....x.....""", "5")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ3109().solve(input));
    }
}
