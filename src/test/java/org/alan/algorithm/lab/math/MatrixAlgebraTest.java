package org.alan.algorithm.lab.math;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MatrixAlgebraTest {

    @Test
    void power() {
        long[][] a = 
                {
                {1,1,1,0,0},
                {0,1,1,0,0},
                {0,0,1,0,0},
                {1,1,1,1,0},
                {1,1,1,1,1}
                };

        System.out.println(Arrays.deepToString(MatrixAlgebra.power(a, 4)));
    }
}