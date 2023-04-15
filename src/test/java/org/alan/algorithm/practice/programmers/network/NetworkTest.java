package org.alan.algorithm.practice.programmers.network;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NetworkTest {

    @Test
    public void test1() {
        int input1 = 3;
        int[][] input2 = {{1,1,0}, {1,1,0}, {0,0,1}};
        int expected = 2;
        Network instance = new Network();
        int answer = instance.solution(input1, input2);
        Assertions.assertEquals(expected, answer);
    }

    @Test
    public void test2() {
        int input1 = 3;
        int[][] input2 = {{1,1,0}, {1,1,1}, {0,1,1}};
        int expected = 1;
        Network instance = new Network();
        int answer = instance.solution(input1, input2);
        Assertions.assertEquals(expected, answer);
    }

    @Test
    public void test3() {
        int input1 = 5;
        int[][] input2 = {{1,1,0,1,1}, {0,1,1,1,1}, {0,0,1,0,0}, {0,0,0,1,1}, {0,0,0,0,1}};
        int expected = 1;
        Network instance = new Network();
        int answer = instance.solution(input1, input2);
        Assertions.assertEquals(expected, answer);
    }

    @Test
    public void test4() {
        int input1 = 5;
        int[][] input2 = {{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}};
        int expected = 4;
        Network instance = new Network();
        int answer = instance.solution(input1, input2);
        Assertions.assertEquals(expected, answer);
    }
}
