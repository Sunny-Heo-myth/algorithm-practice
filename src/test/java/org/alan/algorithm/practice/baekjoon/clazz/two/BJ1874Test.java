package org.alan.algorithm.practice.baekjoon.clazz.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1874Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                                8
                                4
                                3
                                6
                                8
                                7
                                5
                                2
                                1""",
                        """
                                +
                                +
                                +
                                +
                                -
                                -
                                +
                                +
                                -
                                +
                                +
                                -
                                -
                                -
                                -
                                -
                                """),
                Arguments.of("""
                                5
                                1
                                2
                                5
                                3
                                4""",
                        "NO")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1874 instance = new BJ1874();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
