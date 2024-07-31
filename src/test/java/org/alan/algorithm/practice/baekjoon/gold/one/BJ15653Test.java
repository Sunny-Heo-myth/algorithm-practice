package org.alan.algorithm.practice.baekjoon.gold.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ15653Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5 5
                        #####
                        #..B#
                        #.#.#
                        #RO.#
                        #####""", "1"),
                Arguments.of("""
                        7 7
                        #######
                        #...RB#
                        #.#####
                        #.....#
                        #####.#
                        #O....#
                        #######""", "5"),
                Arguments.of("""
                        7 7
                        #######
                        #..R#B#
                        #.#####
                        #.....#
                        #####.#
                        #O....#
                        #######""", "5"),
                Arguments.of("""
                        10 10
                        ##########
                        #R#...##B#
                        #...#.##.#
                        #####.##.#
                        #......#.#
                        #.######.#
                        #.#...##.#
                        #.#.#.#..#
                        #...#.O#.#
                        ##########""", "12"),
                Arguments.of("""
                        3 7
                        #######
                        #R.O.B#
                        #######""", "1"),
                Arguments.of("""
                        10 10
                        ##########
                        #R#...##B#
                        #...#.##.#
                        #####.##.#
                        #......#.#
                        #.######.#
                        #.#....#.#
                        #.#.##...#
                        #O..#....#
                        ##########""", "7"),
                Arguments.of("""
                        3 10
                        ##########
                        #.O....RB#
                        ##########""", "-1")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ15653().solve(input));
    }
}
