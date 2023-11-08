package org.alan.algorithm.lab.math;

import java.util.stream.IntStream;

public final class MatrixAlgebra {
    private static final String INCOMPATIBLE_PARAMETER = "Parameter is incompatible.";

    public static long[][] multiply(long[][] x, long[][] y) {
        if (x[0].length != y.length) throw new IllegalArgumentException(INCOMPATIBLE_PARAMETER);

        long[][] result = new long[x.length][y[0].length];
        for (int i = 0; i < x.length; i++) for (int j = 0; j < y[0].length; j++) {
            long element = 0;
            for (int k = 0; k < y.length; k++) element += (x[i][k] * y[k][j]);
            result[i][j] = element;
        }

        return result;
    }

    public static int[][] multiply(int[][] x, int[][] y) {
        if (x[0].length != y.length) throw new IllegalArgumentException(INCOMPATIBLE_PARAMETER);

        int[][] result = new int[x.length][y[0].length];
        for (int i = 0; i < x.length; i++) for (int j = 0; j < y[0].length; j++) {
            int finalI = i;
            int finalJ = j;
            result[i][j] = IntStream.range(0, y.length).map(k -> x[finalI][k] * y[k][finalJ]).sum();
        }

        return result;
    }

    /**
     * @param x must be square matrix.
     * @param n should be smaller than 63.
     * @return n powered matrix.
     */
    public static long[][] power(long[][] x, int n) {
        if (x.length != x[0].length) throw new IllegalArgumentException(INCOMPATIBLE_PARAMETER);
        if (n == 1) return x;

        long[][] halfPowered = power(x, n / 2);
        long[][] powered = multiply(halfPowered, halfPowered);
        if (n % 2 == 0) return powered;
        else return multiply(x, powered);
    }

}
