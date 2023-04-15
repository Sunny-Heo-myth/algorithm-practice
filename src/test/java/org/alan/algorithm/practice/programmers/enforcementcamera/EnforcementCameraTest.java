package org.alan.algorithm.practice.programmers.enforcementcamera;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class EnforcementCameraTest {

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(int[][] routes, int expected) {
        EnforcementCamera instance = new EnforcementCamera();
        Assertions.assertEquals(expected, instance.solution(routes));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(int[][] routes, int expected) {
        EnforcementCamera2 instance = new EnforcementCamera2();
        Assertions.assertEquals(expected, instance.solution(routes));
    }
}
