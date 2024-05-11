package org.alan.algorithm.practice.baekjoon.silver.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ3184Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        6 6
                        ...#..
                        .##v#.
                        #v.#.#
                        #.o#.#
                        .###.#
                        ...###""", "0 2"),
                Arguments.of("""
                        8 8
                        .######.
                        #..o...#
                        #.####.#
                        #.#v.#.#
                        #.#.o#o#
                        #o.##..#
                        #.v..v.#
                        .######.""", "3 1"),
                Arguments.of("""
                        9 12
                        .###.#####..
                        #.oo#...#v#.
                        #..o#.#.#.#.
                        #..##o#...#.
                        #.#v#o###.#.
                        #..#v#....#.
                        #...v#v####.
                        .####.#vv.o#
                        .......####.""", "3 5")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ3184().solve(input));
    }
}
