package programmers.lv2.coloringBook;

import java.util.Stack;

public class Programmers1829_3 {

    public static void main(String[] args) {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] y = solution(6, 4, picture);
        System.out.println(y[0]);
        System.out.println(y[1]);
    }


    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int sizeOfOneArea;
        boolean[][] booleanPicture = new boolean[m][n];
        // update booleanPicture : initialize true for blank(0).
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(picture[i][j] == 0) booleanPicture[i][j] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!booleanPicture[i][j]) {
                    booleanPicture[i][j] = true;
                    numberOfArea++;
                    sizeOfOneArea = dfs(i ,j, picture, booleanPicture);
                    if (sizeOfOneArea > maxSizeOfOneArea) maxSizeOfOneArea = sizeOfOneArea;
                }
            }
        }
        int[] answer = {numberOfArea, maxSizeOfOneArea};
        return answer;
    }

    // from startingPoint update booleanPicture
    // return sizeOfOne
    public static int dfs(int axis1st, int axis2nd, int[][] picture, boolean[][] booleanPicture) {
        int sizeOfOneArea = 1;
        int[] dAxis1st = {1, -1, 0, 0};
        int[] dAxis2nd = {0, 0, 1, -1};
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{axis1st, axis2nd});
        while (!stack.isEmpty()) {
            int[] nowPoint = stack.pop();
            for (int i = 0; i < 4; i++) {
                int nextAxis1st = nowPoint[0] + dAxis1st[i];
                int nextAxis2nd = nowPoint[1] + dAxis2nd[i];

                if (nextAxis1st < 0 || nextAxis1st >= picture.length ||
                    nextAxis2nd < 0 || nextAxis2nd >= picture[0].length ||
                    booleanPicture[nextAxis1st][nextAxis2nd]) continue;

                if (picture[axis1st][axis2nd] == picture[nextAxis1st][nextAxis2nd]) {
                    booleanPicture[nextAxis1st][nextAxis2nd] = true;
                    sizeOfOneArea++;
                    stack.push(new int[]{nextAxis1st, nextAxis2nd});
                }
            }
        }
        return  sizeOfOneArea;
    }

}
