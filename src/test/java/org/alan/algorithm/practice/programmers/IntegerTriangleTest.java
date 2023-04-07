package org.alan.algorithm.practice.programmers;

import org.alan.algorithm.practice.programmers.integertriangle.IntegerTriangle;
import org.alan.algorithm.practice.programmers.integertriangle.IntegerTriangle2;
import org.alan.algorithm.practice.programmers.integertriangle.IntegerTriangle3;
import org.alan.algorithm.practice.programmers.integertriangle.IntegerTriangle4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IntegerTriangleTest {

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}, 30)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(int[][] input, int expected) {
        IntegerTriangle instance = new IntegerTriangle();
        int answer = instance.solution(input);
        Assertions.assertEquals(expected, answer);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(int[][] input, int expected) {
        IntegerTriangle2 instance = new IntegerTriangle2();
        int answer = instance.solution(input);
        Assertions.assertEquals(expected, answer);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test3(int[][] input, int expected) {
        IntegerTriangle3 instance = new IntegerTriangle3();
        int answer = instance.solution(input);
        Assertions.assertEquals(expected, answer);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test4(int[][] input, int expected) {
        IntegerTriangle4 instance = new IntegerTriangle4();
        int answer = instance.solution(input);
        Assertions.assertEquals(expected, answer);
    }
}
