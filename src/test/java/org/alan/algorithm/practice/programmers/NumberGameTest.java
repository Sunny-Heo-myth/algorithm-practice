package org.alan.algorithm.practice.programmers;

import org.alan.algorithm.practice.programmers.numbergame.NumberGame;
import org.alan.algorithm.practice.programmers.numbergame.NumberGame2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class NumberGameTest {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(3, new int[]{5,1,3,7}, new int[]{2,2,6,8}),
                Arguments.of(0, new int[]{2,2,2,2}, new int[]{1,1,1,1})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(int expected, int[] inputA, int[] inputB) {
        NumberGame instance = new NumberGame();
        Assertions.assertEquals(expected, instance.solution(inputA, inputB));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(int expected, int[] inputA, int[] inputB) {
        NumberGame2 instance = new NumberGame2();
        Assertions.assertEquals(expected, instance.solution(inputA, inputB));
    }

}
