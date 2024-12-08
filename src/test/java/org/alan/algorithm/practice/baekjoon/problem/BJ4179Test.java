package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ4179Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1 1
                        J""", "1"),
                Arguments.of("""
                        4 4
                        ####
                        #JF#
                        #..#
                        #..#""", "3"),
                Arguments.of("""
                        4 4
                        ####
                        #JF#
                        #..#
                        ##.#""", "IMPOSSIBLE"),
                Arguments.of("""
                        4 4
                        ####
                        #.F#
                        #J.#
                        ##.#""", "IMPOSSIBLE"),
                Arguments.of("""
                        4 4
                        ####
                        #.F#
                        #.J#
                        ##.#""", "2"),
                Arguments.of("""
                        8 8
                        ########
                        #.F.....
                        #.J#...#
                        ##.#...#
                        #..#...#
                        #.##.###
                        #......#
                        ########""", "IMPOSSIBLE"),
                Arguments.of("""
                        8 8
                        ########
                        #.F.....
                        #.J#...#
                        ##.#...#
                        #..#...#
                        #.##.###
                        #.......
                        ########""", "IMPOSSIBLE"),
                Arguments.of("""
                        8 8
                        ########
                        #.F.....
                        #.J#...#
                        ##.#...#
                        #..#...#
                        #.##.###
                        #.......
                        ########""", "IMPOSSIBLE"),
                Arguments.of("""
                        8 8
                        ########
                        #.F.....
                        #.J#...#
                        ##.#...#
                        #..#...#
                        #..#.###
                        #.......
                        ########""", "10"),
                Arguments.of("""
                        8 8
                        ######.#
                        #....#.#
                        #.J#...#
                        ##.###.#
                        #..#...#
                        #..#F###
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
                        #J....F#
                        ########""", "7"),
                Arguments.of("""
                        8 8
                        ###....#
                        #......#
                        #......#
                        #......#
                        #......#
                        #......#
                        #J....F#
                        ########""", "9"),
                Arguments.of("""
                        17 5
                        #....
                        F....
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
                        F...#
                        .....
                        .....
                        #J...
                        F.#..""", "4")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ4179().solve(input));
    }

}
