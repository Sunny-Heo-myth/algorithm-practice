package org.alan.algorithm.practice.programmers.connectisland;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ConnectIslandTest {
    
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(4, 4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}})
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(int expected, int n, int[][] costs) {
        ConnectIsland instance = new ConnectIsland();
        Assertions.assertEquals(expected, instance.solution(n, costs));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(int expected, int n, int[][] costs) {
        ConnectIsland2 instance = new ConnectIsland2();
        Assertions.assertEquals(expected, instance.solution(n, costs));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test3(int expected, int n, int[][] costs) {
        ConnectIsland3 instance = new ConnectIsland3();
        Assertions.assertEquals(expected, instance.solution(n, costs));
    }
}
