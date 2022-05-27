package com.baekjoonPractice.stepByStep.recursionStep;

import basicDataStructure.array.Array;

import java.util.Arrays;
import java.util.Scanner;

public class BJ2447_3 {

    char[][] chars;

    public BJ2447_3(int size) {
        this.chars = new char[size][size];
    }

    public char[][] recur(int size) {

        if (size == 3) {
            return new char[][]{{'*', '*', '*'}, {'*', ' ', '*'}, {'*', '*', '*'}};
        }

        char[][] destination = new char[size][size];
        int unitSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (i != 1 || j != 1) {
                    fillUnitArray(i * unitSize, j * unitSize, unitSize, recur(unitSize), destination);
                }
                else {
                    char[] chars1dArray = new char[unitSize];
                    Arrays.fill(chars1dArray, ' ');
                    char[][] chars2dArray = new char[unitSize][unitSize];
                    Arrays.fill(chars2dArray, chars1dArray);

                    fillUnitArray(i * unitSize, j * unitSize, unitSize, chars2dArray, destination);
                }
            }
        }
        return destination;
    }

    public void fillUnitArray(int rowIndex, int columnIndex, int unitSize, char[][] source, char[][] destination) {
        for (int i = 0; i < unitSize; i++) {
            System.arraycopy(source[i], 0, destination[rowIndex + i], columnIndex, unitSize);
        }
    }

    public String stringify() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : this.chars) {
            sb.append(String.valueOf(row)).append("\n");
        }
        return sb.toString();
    }

}
