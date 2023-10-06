package org.alan.algorithm.practice.baekjoon.level.two;

import org.junit.jupiter.api.Test;

public class BJ14502_2Test {

    @Test
    void test_1() {
        String input = "7 7\n" +
                "2 0 0 0 1 1 0\n" +
                "0 0 1 0 1 2 0\n" +
                "0 1 1 0 1 0 0\n" +
                "0 1 0 0 0 0 0\n" +
                "0 0 0 0 0 1 1\n" +
                "0 1 0 0 0 0 0\n" +
                "0 1 0 0 0 0 0";

        BJ14502_2 instance = BJ14502_2.createInstance(input);
        System.out.println(instance.simulate());
    }

    @Test
    void test_2() {
        String input = "4 6\n" +
                "0 0 0 0 0 0\n" +
                "1 0 0 0 0 2\n" +
                "1 1 1 0 0 2\n" +
                "0 0 0 0 0 2";

        BJ14502_2 instance = BJ14502_2.createInstance(input);
    }

    @Test
    void test_3() {
        String input = "8 8\n" +
                "2 0 0 0 0 0 0 2\n" +
                "2 0 0 0 0 0 0 2\n" +
                "2 0 0 0 0 0 0 2\n" +
                "2 0 0 0 0 0 0 2\n" +
                "2 0 0 0 0 0 0 2\n" +
                "0 0 0 0 0 0 0 0\n" +
                "0 0 0 0 0 0 0 0\n" +
                "0 0 0 0 0 0 0 0";

        BJ14502_2 instance = BJ14502_2.createInstance(input);
    }
}
