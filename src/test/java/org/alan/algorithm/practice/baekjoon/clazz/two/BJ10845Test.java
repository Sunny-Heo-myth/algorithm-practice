package org.alan.algorithm.practice.baekjoon.clazz.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10845Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        15
                        push 1
                        push 2
                        front
                        back
                        size
                        empty
                        pop
                        pop
                        pop
                        size
                        empty
                        pop
                        push 3
                        empty
                        front""", """
                        1
                        2
                        2
                        0
                        1
                        2
                        -1
                        0
                        1
                        -1
                        0
                        3"""),
                Arguments.of("""
                                10
                                push 1
                                push 2
                                push 2
                                push 2
                                push 2
                                push 2
                                pop
                                pop
                                pop
                                push 2""",
                        """
                                1
                                2
                                2""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ10845 instance = new BJ10845();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
