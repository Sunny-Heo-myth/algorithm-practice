package org.alan.algorithm.practice.baekjoon.stepbystep.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ14725Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3
                        2 B A
                        4 A B C D
                        2 A C""", """
                        A
                        --B
                        ----C
                        ------D
                        --C
                        B
                        --A
                        """),
                Arguments.of("""
                        4
                        2 KIWI BANANA
                        2 KIWI APPLE
                        2 APPLE APPLE
                        3 APPLE BANANA KIWI""", """
                        APPLE
                        --APPLE
                        --BANANA
                        ----KIWI
                        KIWI
                        --APPLE
                        --BANANA
                        """)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ14725().solve(input));
    }
}
