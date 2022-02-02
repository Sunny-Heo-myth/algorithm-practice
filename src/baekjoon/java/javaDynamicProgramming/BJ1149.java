package baekjoon.java.javaDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1149 {
    static int[][] costArr;
    static int[][] minimumCostArr;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        costArr = new int[num][3];
        minimumCostArr = new int[num][3];
        StringTokenizer st;
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                costArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        minimumCostArr[0][0] = costArr[0][0];
        minimumCostArr[0][1] = costArr[0][1];
        minimumCostArr[0][2] = costArr[0][2];

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            coloringMinimum(num - 1, i);
            answer = Math.min(answer, minimumCostArr[num - 1][i]);
        }
        System.out.print(answer);
    }

    static int coloringMinimum(int index1st, int index2nd) {
        int result = Integer.MAX_VALUE;
        if (index1st == 0) {
            return minimumCostArr[0][index2nd];
        }

        if (minimumCostArr[index1st][index2nd] == 0) {
            minimumCostArr[index1st][index2nd] = costArr[index1st][index2nd] +
                    Math.min(coloringMinimum(index1st - 1,(index2nd + 1) % 3),
                            coloringMinimum(index1st - 1, (index2nd + 2) % 3));
        }

        return minimumCostArr[index1st][index2nd];
    }
}
