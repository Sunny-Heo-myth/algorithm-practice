package org.alan.algorithm.practice.baekjoon.level.four;

import org.alan.algorithm.lab.math.MatrixAlgebra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BJ2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BJ2740 instance = new BJ2740();
        int[][] first = instance.getMatrix(bf);
        int[][] second = instance.getMatrix(bf);
        int[][] result = MatrixAlgebra.multiply(first, second);
        instance.write(result);
        bf.close();
    }

    private void write(int[][] result) {
        System.out.print(Arrays.stream(result)
                .map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n")));
    }

    private int[][] getMatrix(BufferedReader bf) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int numberOfRow = Integer.parseInt(st.nextToken());
        int numberOfColumn = Integer.parseInt(st.nextToken());
        int[][] matrix1 = new int[numberOfRow][numberOfColumn];
        for (int i = 0; i < numberOfRow; i++) matrix1[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        return matrix1;
    }

    public String solve(String input) {
        String[] s = input.split("\n");
        StringTokenizer st = new StringTokenizer(s[0]);

        return null;
    }
}
