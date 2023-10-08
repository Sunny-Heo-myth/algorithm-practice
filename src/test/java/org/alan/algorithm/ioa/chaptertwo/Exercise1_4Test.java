package org.alan.algorithm.ioa.chaptertwo;

import org.junit.jupiter.api.Test;

public class Exercise1_4Test {

    @Test
    void test1() {
        boolean[] a = {true, true, true};
        boolean[] b = {true, true, true};
        Exercise1_4 instance = new Exercise1_4(a, b);
        for (boolean bool : instance.c) {
            System.out.println(bool);
        }
    }

    @Test
    void test2() {
        boolean[] a = {false, true, true};
        boolean[] b = {true, false, false};
        Exercise1_4 instance = new Exercise1_4(a, b);
        for (boolean bool : instance.c) {
            System.out.println(bool);
        }
    }
}
