package org.alan.algorithm.practice.baekjoon.silver.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2529Test {   // todo:
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        2
                        < >""", """
                        897
                        021"""),
                Arguments.of("""
                        9
                        > < < < > > > < <""", """
                        9567843012
                        1023765489""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2529().solve(input));
    }
}
