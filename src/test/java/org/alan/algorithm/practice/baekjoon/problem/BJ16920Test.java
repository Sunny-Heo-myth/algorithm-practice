package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ16920Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1 1 1
                        1
                        1""", "1"),
                Arguments.of("""
                        3 3 1
                        1
                        1..
                        ...
                        ...""", "9"),
                Arguments.of("""
                        3 3 2
                        1 1
                        1..
                        ...
                        ..2""", "6 3"),
                Arguments.of("""
                        3 3 2
                        1 1
                        1.1
                        ...
                        ..2""", "7 2"),
                Arguments.of("""
                        4 4 2
                        1 1
                        1...
                        ....
                        ....
                        ...2""", "10 6"),
                Arguments.of("""
                        4 4 2
                        1 1
                        1..1
                        ....
                        ....
                        ...2""", "11 5"),
                Arguments.of("""
                        4 4 2
                        2 1
                        1..1
                        ....
                        ....
                        ...2""", "14 2"),
                Arguments.of("""
                        4 4 2
                        3 1
                        1..1
                        ....
                        ....
                        ...2""", "14 2"),
                Arguments.of("""
                        4 4 2
                        1 1
                        1..1
                        #.##
                        ....
                        ...2""", "7 6"),
                Arguments.of("""
                        4 4 2
                        2 1
                        1..1
                        #.##
                        ....
                        ...2""", "10 3"),
                Arguments.of("""
                        3 4 4
                        1 1 1 1
                        ....
                        #...
                        1234""", "1 4 3 3"),
                Arguments.of("""
                        3 4 1
                        1
                        ....
                        #...
                        1#..""", "1"),
                Arguments.of("""
                        3 4 1
                        1
                        ....
                        #...
                        1#..""", "1"),
                Arguments.of("""
                        3 4 4
                        1 1 2 2
                        4#..
                        #3..
                        1#2.""", "1 6 1 1"),
                Arguments.of("""
                        5 10 4
                        1 2 1 2
                        1........2
                        .....44...
                        ......4...
                        2.........
                        ....3.....""", "5 21 4 20")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ16920().solve(input));
    }
}
