package org.alan.algorithm.ioa.divideandconquer;

import org.junit.jupiter.api.Test;

public class Chapter4Test {

    @Test
    void test1() {
        int[] array = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4 , 7};
        Chapter4 instance = new Chapter4();
        Chapter4.Answer answer = instance.findMaximumArray(array, 0, 15);
        System.out.println(answer.getMaxSum());
        System.out.println(answer.getFromIndex());
        System.out.print(answer.getToIndex());
    }

    @Test
    void test2() {
        int[] array = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4 , 7};
        Chapter4 instance = new Chapter4();
        Chapter4.Answer answer = instance.findMaximumArray_bruteForce(array);
        System.out.println(answer.getMaxSum());
        System.out.println(answer.getFromIndex());
        System.out.print(answer.getToIndex());
    }
}
