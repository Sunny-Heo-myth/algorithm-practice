package org.alan.algorithm.practice.programmers.overtimeindex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OvertimeIndexTest {

//    @Test
//    public void test1_1() {
//        int n = 4;
//        int[] works = {4, 3, 3};
//        int expected = 12;
//        OvertimeIndex instance = new OvertimeIndex();
//        Assertions.assertEquals(expected, instance.solution(n, works));
//    }
//
//    @Test
//    public void test1_2() {
//        int n = 1;
//        int[] works = {2, 1, 2};
//        int expected = 6;
//        OvertimeIndex instance = new OvertimeIndex();
//        Assertions.assertEquals(expected, instance.solution(n, works));
//    }
//
//    @Test
//    public void test1_3() {
//        int n = 3;
//        int[] works = {1, 1};
//        int expected = 0;
//        OvertimeIndex instance = new OvertimeIndex();
//        Assertions.assertEquals(expected, instance.solution(n, works));
//    }

    @Test
    public void test2_1() {
        int n = 4;
        int[] works = {4, 3, 3};
        int expected = 12;
        OvertimeIndex2 instance = new OvertimeIndex2();
        Assertions.assertEquals(expected, instance.solution(n, works));
    }

    @Test
    public void test2_2() {
        int n = 1;
        int[] works = {2, 1, 2};
        int expected = 6;
        OvertimeIndex2 instance = new OvertimeIndex2();
        Assertions.assertEquals(expected, instance.solution(n, works));
    }

    @Test
    public void test2_3() {
        int n = 3;
        int[] works = {1, 1};
        int expected = 0;
        OvertimeIndex2 instance = new OvertimeIndex2();
        Assertions.assertEquals(expected, instance.solution(n, works));
    }
}
