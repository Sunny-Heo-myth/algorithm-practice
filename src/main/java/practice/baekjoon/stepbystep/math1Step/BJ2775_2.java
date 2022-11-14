package practice.baekjoon.stepbystep.math1Step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2775_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(bf.readLine());
        int[][] input = new int[cases][2];

        for (int i = 0; i < cases; i++) {
            int floor = Integer.parseInt(bf.readLine());
            int width = Integer.parseInt(bf.readLine());
            input[i][0] = floor;
            input[i][1] = width;
        }

        for (int[] i : input) {
            System.out.println(solve(i[0], i[1]));
        }
    }


    private static int solve(int floor, int width) {
        if (floor == 0) {
            return width;
        }
        if (width == 1) {
            return 1;
        }
        return solve(floor - 1, width) + solve(floor, width - 1);
    }


}
