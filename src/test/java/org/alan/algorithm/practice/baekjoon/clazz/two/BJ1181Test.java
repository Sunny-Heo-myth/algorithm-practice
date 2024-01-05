package org.alan.algorithm.practice.baekjoon.clazz.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1181Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        13
                        but
                        i
                        wont
                        hesitate
                        no
                        more
                        no
                        more
                        it
                        cannot
                        wait
                        im
                        yours""", """
                        i
                        im
                        it
                        no
                        but
                        more
                        wait
                        wont
                        yours
                        cannot
                        hesitate""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1181().solve(input));
    }
}
