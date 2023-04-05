package org.alan.algorithm.practice.programmers.coloringbook;

import java.util.Stack;

public class Programmers1829_5 {

    public static void main(String[] args) {

        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] a = solution(6, 4, picture);
        System.out.println(a[0] + " " + a[1]);
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxArea = Integer.MIN_VALUE;
        int[] axis1st = {1, -1, 0 ,0}, axis2nd = {0 ,0, 1, -1};
        
        boolean[][] booleans = new boolean[m][n];
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            if (picture[i][j] == 0) booleans[i][j] = true;
        }
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            if (booleans[i][j]) continue;

            numberOfArea++;
            int area = 0;
            booleans[i][j] = true;
            Stack<int[]> stack = new Stack<>();
            stack.push(new int[]{i, j});
            while (!stack.isEmpty()) {
                area++;
                int[] nowPoint = stack.pop();
                int nowColor = picture[nowPoint[0]][nowPoint[1]];

                for (int k = 0; k < 4; k++) {
                    int nextAxis1st = nowPoint[0] + axis1st[k];
                    int nextAxis2nd = nowPoint[1] + axis2nd[k];

                    if (nextAxis1st < 0 || nextAxis1st >= m ||
                        nextAxis2nd < 0 || nextAxis2nd >= n ||
                        booleans[nextAxis1st][nextAxis2nd]) continue;

                    int nextColor = picture[nextAxis1st][nextAxis2nd];

                    if (nowColor == nextColor) {
                        booleans[nextAxis1st][nextAxis2nd] = true;
                        stack.push(new int[]{nextAxis1st, nextAxis2nd});
                    }

                }
            }
            if (maxArea <= area) maxArea = area;
        }

        int[] answer = {numberOfArea, maxArea};
        return answer;
    }


}
