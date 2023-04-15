package org.alan.algorithm.practice.programmers.bestset;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BestSetTest {

    @Test
    public void test1() {
        int input1 = 2, input2 = 9;
        int[] expected = {4, 5};
        BestSet instance = new BestSet();
        int[] answer = instance.solution(input1, input2);
        Assertions.assertEquals(expected[0], answer[0]);
        Assertions.assertEquals(expected[1], answer[1]);
    }

    @Test
    public void test2() {
        int input1 = 2, input2 = 1;
        int[] expected = {-1};
        BestSet instance = new BestSet();
        int[] answer = instance.solution(input1, input2);
        Assertions.assertEquals(expected[0], answer[0]);
    }

    @Test
    public void test3() {
        int input1 = 2, input2 = 8;
        int[] expected = {4, 4};
        BestSet instance = new BestSet();
        int[] answer = instance.solution(input1, input2);
        Assertions.assertEquals(expected[0], answer[0]);
        Assertions.assertEquals(expected[1], answer[1]);
    }

}
