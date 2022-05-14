package baekjoon.stepByStep.javaDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1932 {
    static int num;
    static int[][] triangle;
    static Integer[][] maxTriangle;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(bf.readLine());
        triangle = new int[num][num];
        maxTriangle = new Integer[num][num];
        StringTokenizer st;
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        maxTriangle[0][0] = triangle[0][0];

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < num; i++) {
            answer = Math.max(answer, maximizing(num - 1, i));
        }
        System.out.print(answer);
    }

    static int maximizing(int index1st, int index2nd) {
        Integer maxElement = maxTriangle[index1st][index2nd];
        if (index1st == 0) {
            return maxTriangle[0][0];
        }

        if (index1st == index2nd) {
            if (maxElement == null) {
                maxTriangle[index1st][index2nd] =
                        triangle[index1st][index2nd] + maximizing(index1st - 1, index2nd - 1);
            }
            return maxTriangle[index1st][index2nd];
        }

        if (index2nd == 0) {
            if (maxElement == null) {
                maxTriangle[index1st][index2nd] =
                        triangle[index1st][index2nd] + maximizing(index1st - 1, index2nd);
            }
            return maxTriangle[index1st][index2nd];
        }

        if (maxElement == null) {
            maxTriangle[index1st][index2nd] = triangle[index1st][index2nd] +
                            Math.max(maximizing(index1st - 1, index2nd - 1),
                                    maximizing(index1st - 1, index2nd));
        }
        return maxTriangle[index1st][index2nd];
    }
}
