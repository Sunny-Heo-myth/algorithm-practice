package org.alan.algorithm.practice.baekjoon.gold.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ15644Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5 5
                        #####
                        #R.B#
                        #.#.#
                        #..O#
                        #####""", """
                        3
                        LDR"""),
                Arguments.of("""
                        5 5
                        #####
                        #R.B#
                        #.#.#
                        #.O.#
                        #####""", """
                        2
                        DR"""),
                Arguments.of("""
                        5 5
                        #####
                        #..B#
                        #.#.#
                        #RO.#
                        #####""", """
                        1
                        R"""),
                Arguments.of("""
                        5 5
                        #####
                        #...#
                        #BO.#
                        #R..#
                        #####""", """
                        2
                        UR"""),
                Arguments.of("""
                        5 5
                        #####
                        #..B#
                        #.O.#
                        #R..#
                        #####""", """
                        3
                        URD"""),
                Arguments.of("""
                        7 7
                        #######
                        #...RB#
                        #.#####
                        #.....#
                        #####.#
                        #O....#
                        #######""", """
                        5
                        LDRDL"""),
                Arguments.of("""
                        7 7
                        #######
                        #...RB#
                        #.....#
                        #.....#
                        #.....#
                        #O....#
                        #######""", """
                        2
                        LD"""),
                Arguments.of("""
                        7 7
                        #######
                        #....B#
                        #.....#
                        #..R..#
                        #.....#
                        #O....#
                        #######""", """
                        3
                        ULD"""),
                Arguments.of("""
                        7 7
                        #######
                        #....B#
                        #.....#
                        #..O..#
                        #.....#
                        #R....#
                        #######""", "-1"),
                Arguments.of("""
                        7 7
                        #######
                        #....B#
                        #.....#
                        #..O..#
                        #...#.#
                        #R....#
                        #######""", """
                        4
                        URDL"""),
                Arguments.of("""
                        10 10
                        ##########
                        #R#...##B#
                        #...#.##.#
                        #####.##.#
                        #......#.#
                        #.######.#
                        #.#....#.#
                        #.#.#.#..#
                        #...#.O#.#
                        ##########""", "-1"),
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
                        ##########""", """
                        7
                        DRURDLD"""),
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
        Assertions.assertEquals(expected, new BJ15644().solve(input));
    }
}
