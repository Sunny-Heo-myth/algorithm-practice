package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ13460Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5 5
                        #####
                        #R.B#
                        #.#.#
                        #..O#
                        #####""", "3"),
                Arguments.of("""
                        5 5
                        #####
                        #R.B#
                        #.#.#
                        #.O.#
                        #####""", "2"),
                Arguments.of("""
                        5 5
                        #####
                        #..B#
                        #.#.#
                        #RO.#
                        #####""", "1"),
                Arguments.of("""
                        5 5
                        #####
                        #...#
                        #BO.#
                        #R..#
                        #####""", "2"),
                Arguments.of("""
                        5 5
                        #####
                        #B..#
                        #.O.#
                        #R..#
                        #####""", "2"),
                Arguments.of("""
                        5 5
                        #####
                        #..B#
                        #.O.#
                        #R..#
                        #####""", "3"),
                Arguments.of("""
                        5 5
                        #####
                        #...#
                        #.O.#
                        #R.B#
                        #####""", "2"),
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
                        #...RB#
                        #.....#
                        #.....#
                        #.....#
                        #O....#
                        #######""", "2"),
                Arguments.of("""
                        7 7
                        #######
                        #....B#
                        #.....#
                        #..R..#
                        #.....#
                        #O....#
                        #######""", "3"),
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
                        #######""", "4"),
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
                        7 7
                        #######
                        #..R#B#
                        #.###.#
                        #.....#
                        #####.#
                        #O....#
                        #######""", "-1"),
                Arguments.of("""
                        7 7
                        #######
                        #..R#B#
                        #.##..#
                        #.....#
                        #####.#
                        #O....#
                        #######""", "7"),
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
                        #......#.#
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
                        #.....##.#
                        ###.#.#..#
                        #...#.O#.#
                        ##########""", "10"),
                Arguments.of("""
                        10 10
                        ##########
                        #R#...##B#
                        #...#.##.#
                        #####.##.#
                        #......#.#
                        #.###.##.#
                        #.#....#.#
                        #.#.#.#..#
                        #...#.O#.#
                        ##########""", "6"),
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
                        ##########""", "-1"),
                Arguments.of("""
                        3 10
                        #####
                        #ROB#
                        #####""", "1"),
                Arguments.of("""
                        3 5
                        #####
                        #RBO#
                        #####""", "-1"),
                Arguments.of("""
                        4 5
                        #####
                        #R..#
                        #.BO#
                        #####""", "-1"),
                Arguments.of("""
                        6 6
                        ######
                        #..#.#
                        #....#
                        #O#..#
                        #B..R#
                        ######""", "8"),
                Arguments.of("""
                        8 8
                        ########
                        #BR.#.O#
                        ###.#..#
                        #...#..#
                        #.###..#
                        #..#..##
                        ##...#.#
                        ########""", "-1"),
                Arguments.of("""
                        6 6
                        ######
                        #R..B#
                        #.#..#
                        #..#O#
                        #....#
                        ######""", "4"),
                Arguments.of("""
                        7 6
                        ######
                        ##.###
                        #O.###
                        ##...#
                        ##R#.#
                        ##B..#
                        ######""", "7"),
                Arguments.of("""
                        8 8
                        ########
                        #BR.#.O#
                        ###.#..#
                        #...#..#
                        #.###..#
                        #..#..##
                        ##...#.#
                        ########""", "-1"),
                Arguments.of("""
                        5 7
                        #######
                        #.RB###
                        #.#.#O#
                        #.....#
                        #######""", "4"),
                Arguments.of("""
                        11 13
                        #############
                        #.RB#########
                        #.#.........#
                        #.#.#######.#
                        #.#.#.....#.#
                        #.#.#..O#.#.#
                        #.#.#####.#.#
                        #.#.......#.#
                        #.#########.#
                        #...........#
                        #############""", "-1"),
                Arguments.of("""
                        11 13
                        #############
                        #RB##########
                        #.#.........#
                        #.#.#######.#
                        #.#.#.....#.#
                        #.#.#..O#.#.#
                        #.#.#####.#.#
                        #.#.......#.#
                        #.#########.#
                        #...........#
                        #############""", "10"),
                Arguments.of("""
                        11 13
                        #############
                        #R###########
                        #B#.........#
                        #.#.#######.#
                        #.#.#.....#.#
                        #.#.#..O#.#.#
                        #.#.#####.#.#
                        #.#.......#.#
                        #.#########.#
                        #...........#
                        #############""", "-1"),
                Arguments.of("""
                        11 13
                        #############
                        #.RB#########
                        #.#.........#
                        #.#.#######.#
                        #.#.#.....#.#
                        #.#.#O..#.#.#
                        #.#.#####.#.#
                        #.#.......#.#
                        #.#########.#
                        #...........#
                        #############""", "10"),
                Arguments.of("""
                        9 10
                        ##########
                        #B......R#
                        ##.O.....#
                        ##.####..#
                        ##.####..#
                        ##.####..#
                        ##.####..#
                        ##.......#
                        ##########""", "4"),
                Arguments.of("""
                        6 3
                        ###
                        #O#
                        #.#
                        #B#
                        #R#
                        ###""", "-1"),
                Arguments.of("""
                        5 10
                        ##########
                        #........#
                        #.####...#
                        #R##O..#B#
                        ##########""", "6"),
                Arguments.of("""
                        6 7
                        #######
                        ##....#
                        ###O#.#
                        #####.#
                        ##RB..#
                        #######""", "8"),
                Arguments.of("""
                        6 7
                        #######
                        #....##
                        #.#O###
                        #.#####
                        #..BR##
                        #######""", "8"),
                Arguments.of("""
                        6 7
                        #######
                        #..BR##
                        #.#####
                        #.#O###
                        #....##
                        #######""", "8"),
                Arguments.of("""
                        6 7
                        #######
                        ##RB..#
                        #####.#
                        ###O#.#
                        ##....#
                        #######""", "8"),
                Arguments.of("""
                        5 8
                        ########
                        #RB.##.#
                        ##.#####
                        #.O..###
                        ########""", "2"),
                Arguments.of("""
                        6 8
                        ########
                        #R....B#
                        ##.#####
                        #......#
                        #.O....#
                        ########""", "-1"),
                Arguments.of("""
                        5 5
                        #####
                        #O..#
                        #R..#
                        #B..#
                        #####""", "3"),
                Arguments.of("""
                        6 7
                        #######
                        #.#.BO#
                        #...###
                        #.....#
                        #R#...#
                        #######""", "-1"),
                Arguments.of("""
                        10 6
                        ######
                        #.#..#
                        #.O.##
                        #.##.#
                        #.R#.#
                        #...##
                        ##..##
                        #.B.##
                        #.#.##
                        ######""", "-1"),
                Arguments.of("""
                        8 6
                        ######
                        #.R..#
                        #.#.##
                        #.B###
                        #.#.O#
                        #.#..#
                        #...##
                        ######""", "-1"),
                Arguments.of("""
                        7 6
                        ######
                        #R#O.#
                        #.#.B#
                        #....#
                        #..#.#
                        #...##
                        ######""", "-1")

        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ13460().solve(input));
    }
}
