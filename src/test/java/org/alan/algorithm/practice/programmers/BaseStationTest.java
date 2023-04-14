package org.alan.algorithm.practice.programmers;

import org.alan.algorithm.practice.programmers.basestation.BaseStation;
import org.alan.algorithm.practice.programmers.basestation.BaseStation3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BaseStationTest {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(3, 11, new int[]{4, 11}, 1),
                Arguments.of(3, 16, new int[]{9}, 2)
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(int expected, int n, int[] stations, int w) {
        BaseStation instance = new BaseStation();
        Assertions.assertEquals(expected, instance.solution(n, stations, w));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test3(int expected, int n, int[] stations, int w) {
        BaseStation3 instance = new BaseStation3();
        Assertions.assertEquals(expected, instance.solution(n, stations, w));
    }
}
