package org.alan.algorithm.practice.baekjoon.stepbystep.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class BJ2447_2 {

    public Matrix matrix;

    public static void main(String[] args) {
        int num = new Scanner(System.in).nextInt();
        BJ2447_2 sample = new BJ2447_2(num);
        sample.matrix.square = sample.recur(num);
        System.out.print(sample.stringify());

    }

    public BJ2447_2(int size) {
        this.matrix = new Matrix(size);
    }

    public boolean[][] recur(int num) {

        if (num == 3) {
            return new boolean[][]{{true, true, true}, {true, false, true}, {true, true, true}};
        }

        int unit = num / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    this.matrix.fillZero(unit);
                }
                else {
                    this.matrix.fill(i, j, unit, recur(num / 3));
                }

            }
        }
        return matrix.getSquare();
    }

    public String stringify() {
        StringBuilder stringBuilder = new StringBuilder();
        for (boolean[] row : this.matrix.square) {
            for (boolean bool : row) {
                if (bool) {
                    stringBuilder.append("*");
                }
                else {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }

    public class Matrix {

        private boolean[][] square;

        public Matrix(int size) {
            this.square = new boolean[size][size];
        }

        public boolean[][] getSquare() {
            return square;
        }

        public void setSquare(boolean[][] square) {
            this.square = square;
        }

        public void fill(int row, int column, int size, boolean[][] booleans) {
            for (int i = 0; i < size; i++) {
                System.arraycopy(booleans[i], 0, this.square[row * size + i], column * size, size);
            }
        }

        public void fillZero(int size) {
            for (int i = 0; i < size; i++) {
                Arrays.fill(this.square[size + i], size, size * 2, false);
            }
        }
    }

}
