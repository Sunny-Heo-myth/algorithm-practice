package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ3197Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1 1
                        L""", "0"),
                Arguments.of("""
                        1 2
                        LL""", "0"),
                Arguments.of("""
                        2 2
                        L.
                        .L""", "0"),
                Arguments.of("""
                        2 2
                        LX
                        .L""", "0"),
                Arguments.of("""
                        2 2
                        LX
                        XL""", "1"),
                Arguments.of("""
                        10 10
                        LXXXXXXXXX
                        XXXXXXXXXX
                        XXXXXXXXXX
                        XXXXXXXXXX
                        XXXXXXXXXX
                        XXXXXXXXXX
                        XXXXXXXXXX
                        XXXXXXXXXX
                        XXXXXXXXXX
                        XXXXXXXXXL""", "9"),
                Arguments.of("""
                        10 2
                        .L
                        ..
                        XX
                        XX
                        XX
                        XX
                        XX
                        XX
                        ..
                        .L""", "3"),
                Arguments.of("""
                        4 11
                        ..XXX...X..
                        .X.XXX...L.
                        ....XXX..X.
                        X.L..XXX...""", "2"),
                Arguments.of("""
                        8 17
                        ...XXXXXX..XX.XXX
                        ....XXXXXXXXX.XXX
                        ...XXXXXXXXXXXX..
                        ..XXXXX.LXXXXXX..
                        .XXXXXX..XXXXXX..
                        XXXXXXX...XXXX...
                        ..XXXXX...XXX....
                        ....XXXXX.XXXL...""", "2")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ3197().solve(input));
    }
}
