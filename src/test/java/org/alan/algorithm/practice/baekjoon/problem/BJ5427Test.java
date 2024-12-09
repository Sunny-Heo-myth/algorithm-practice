package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ5427Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        17 5
                        #....
                        *....
                        #.#..
                        .....
                        .....
                        .....
                        .....
                        .....
                        .....
                        .....
                        .....
                        #...#
                        *...#
                        .....
                        .....
                        #@...
                        *.#..""", "4"),
                Arguments.of("""
                        1 1
                        @""", "1"),
                Arguments.of("""
                        4 3
                        ####
                        #*@.
                        ####""", "2"),
                Arguments.of("""
                        7 6
                        ###.###
                        #*#.#*#
                        #.....#
                        #.....#
                        #..@..#
                        #######""", "5"),
                Arguments.of("""
                        7 4
                        ###.###
                        #....*#
                        #@....#
                        .######""", "IMPOSSIBLE"),
                Arguments.of("""
                        5 5
                        .....
                        .***.
                        .*@*.
                        .***.
                        .....""", "IMPOSSIBLE"),
                Arguments.of("""
                        3 3
                        ###
                        #@#
                        ###""", "IMPOSSIBLE"),
                Arguments.of("""
                        4 4
                        ####
                        #@*#
                        #..#
                        #..#""", "3"),
                Arguments.of("""
                        4 4
                        ####
                        #@*#
                        #..#
                        ##.#""", "IMPOSSIBLE"),
                Arguments.of("""
                        4 4
                        ####
                        #.*#
                        #@.#
                        ##.#""", "IMPOSSIBLE"),
                Arguments.of("""
                        4 4
                        ####
                        #.*#
                        #.@#
                        ##.#""", "2"),
                Arguments.of("""
                        8 8
                        ########
                        #.*.....
                        #.@#...#
                        ##.#...#
                        #..#...#
                        #.##.###
                        #......#
                        ########""", "IMPOSSIBLE"),
                Arguments.of("""
                        8 8
                        ########
                        #.*.....
                        #.@#...#
                        ##.#...#
                        #..#...#
                        #.##.###
                        #.......
                        ########""", "IMPOSSIBLE"),
                Arguments.of("""
                        8 8
                        ########
                        #.*.....
                        #.@#...#
                        ##.#...#
                        #..#...#
                        #.##.###
                        #.......
                        ########""", "IMPOSSIBLE"),
                Arguments.of("""
                        8 8
                        ########
                        #.*.....
                        #.@#...#
                        ##.#...#
                        #..#...#
                        #..#.###
                        #.......
                        ########""", "10"),
                Arguments.of("""
                        8 8
                        ######.#
                        #....#.#
                        #.@#...#
                        ##.###.#
                        #..#...#
                        #..#*###
                        #......#
                        ########""", "IMPOSSIBLE"),
                Arguments.of("""
                        8 8
                        #......#
                        #......#
                        #......#
                        #......#
                        #......#
                        #......#
                        #@....*#
                        ########""", "7"),
                Arguments.of("""
                        8 8
                        ###....#
                        #......#
                        #......#
                        #......#
                        #......#
                        #......#
                        #@....*#
                        ########""", "9")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ5427().solve(input));
    }
}
