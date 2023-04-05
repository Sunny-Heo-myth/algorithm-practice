package org.alan.algorithm.practice.programmers;

import org.alan.algorithm.practice.programmers.integertriangle.IntegerTriangle;
import org.alan.algorithm.practice.programmers.integertriangle.IntegerTriangle2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerTriangleTest {

    @Test
    public void test1() {
        int[][] input = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int expected = 30;
        IntegerTriangle instance = new IntegerTriangle();
        int answer = instance.solution(input);
        Assertions.assertEquals(expected, answer);
    }

    @Test
    public void test2() {
        int[][] input = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int expected = 30;
        IntegerTriangle2 instance = new IntegerTriangle2();
        int answer = instance.solution(input);
        Assertions.assertEquals(expected, answer);
    }
}
