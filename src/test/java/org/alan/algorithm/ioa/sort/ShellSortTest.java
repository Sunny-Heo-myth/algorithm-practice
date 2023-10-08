package org.alan.algorithm.ioa.sort;

import org.junit.jupiter.api.BeforeEach;

import java.util.Random;



public class ShellSortTest {

    static int[] target;
    @BeforeEach
    public void before() {
        Random random = new Random();
        target = new int[100];
        for (int i = 0; i < 100; i++) {
            target[i] = random.nextInt();
        }
    }

//    @Test
//    public void shellSortTest() {
//        shellSort2(target);
//        for (int i : target) {
//            System.out.print(i + " ");
//        }
//    }
}
