package org.alan.algorithm.practice.baekjoon.gold.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1759Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4 6
                        a t c i s w""", """
                        acis
                        acit
                        aciw
                        acst
                        acsw
                        actw
                        aist
                        aisw
                        aitw
                        astw
                        cist
                        cisw
                        citw
                        istw""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1759().solve(input));
    }
}
