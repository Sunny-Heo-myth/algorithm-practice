package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ9328Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5 17
                        *****************
                        .............**$*
                        *B*A*P*C**X*Y*.X.
                        *y*x*a*p**$*$**$*
                        *****************
                        cz""", "3"),
                Arguments.of("""
                        5 11
                        *.*********
                        *...*...*x*
                        *X*.*.*.*.*
                        *$*...*...*
                        ***********
                        0""", "1"),
                Arguments.of("""
                        7 7
                        *ABCDE*
                        X.....F
                        W.$$$.G
                        V.$$$.H
                        U.$$$.J
                        T.....K
                        *SQPML*
                        irony""", "0"),
                Arguments.of("""
                        7 7
                        *ABCDE*
                        X.....F
                        W.$$$.G
                        V.$$$.H
                        U.$$$.J
                        T.....K
                        *SQPML*
                        arony""", "9"),
                Arguments.of("""
                        7 7
                        *ABCDE*
                        .w*...F
                        *I*$$.G
                        VW*$$.H
                        UN*$$.J
                        TY....K
                        *SQPML*
                        irony""", "6")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ9328().solve(input));
    }
}
