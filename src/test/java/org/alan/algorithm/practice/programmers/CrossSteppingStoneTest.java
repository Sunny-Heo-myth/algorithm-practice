package org.alan.algorithm.practice.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CrossSteppingStoneTest {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(3, new int[]{2,4,5,3,2,1,4,2,5,1}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(int expected, int[] stones, int k) {
        CrossSteppingStone instance = new CrossSteppingStone();
        Assertions.assertEquals(expected, instance.solution(stones, k));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(int expected, int[] stones, int k) {
        CrossSteppingStone2 instance = new CrossSteppingStone2();
        Assertions.assertEquals(expected, instance.solution(stones, k));
    }
}
