package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ5430Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                                RDD
                                4
                                [1,2,3,4]""",
                        "[2,1]"),
                Arguments.of("""
                                DD
                                1
                                [42]""",
                        "error"),
                Arguments.of("""
                                RRD
                                6
                                [1,1,2,3,5,8]""",
                        "[1,2,3,5,8]"),
                Arguments.of("""
                                D
                                0
                                []""",
                        "error"),
                Arguments.of("""
                                DDRDD
                                5
                                [1,1,2,3,5]""",
                        "[2]"),
                Arguments.of("""
                                DDDDR
                                5
                                [1,1,2,3,5]""",
                        "[5]")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ5430 instance = new BJ5430();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
