package practice.programmers.coloringBook;

import java.util.Stack;

public class Programmers1829_4 {
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int sizeOfOneArea;

    public static void main(String[] args) {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] y = solution(6, 4, picture);
        System.out.println(y[0]);
        System.out.println(y[1]);
    }

    public static int[] solution(int m, int n, int[][] picture) {

        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        sizeOfOneArea = 1;
        // delete all blank
        boolean[][] booleanPicture = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0)
                    booleanPicture[i][j] = true;
            }
        }
        // check non-blank "one by one" by truing starting point
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!booleanPicture[i][j]) {
                    booleanPicture[i][j] = true;
                    dfs(i ,j, picture, booleanPicture);
                    numberOfArea++;
                    if (maxSizeOfOneArea < sizeOfOneArea) maxSizeOfOneArea = sizeOfOneArea;
                }
                sizeOfOneArea = 1;
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    // input starting point, image, boolean image
    // operation : while stack is unempty & while comparable is false,
    // if
    public static void dfs(int m, int n, int[][] picture, boolean[][] booleanPicture) {
        int length1st = picture.length;
        int length2nd = picture[0].length;
        int nowColor = picture[m][n];
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{m, n});
        int[] dAxis1st = {1, 0, -1, 0};
        int[] dAxis2nd = {0, 1, 0, -1};

        while(!stack.isEmpty()){
            int[] nowPoint = stack.pop();
            for (int i = 0; i < 4; i++) {
                int nextAxis1st = nowPoint[0] + dAxis1st[i];
                int nextAxis2nd = nowPoint[1] + dAxis2nd[i];
                if (nextAxis1st < 0 || nextAxis1st >= length1st ||
                    nextAxis2nd < 0 || nextAxis2nd >= length2nd ||
                    booleanPicture[nextAxis1st][nextAxis2nd]) continue;

                int nextColor = picture[nextAxis1st][nextAxis2nd];

                if (nowColor == nextColor) {
                    sizeOfOneArea++;
                    booleanPicture[nextAxis1st][nextAxis2nd] = true;
                    stack.push(new int[]{nextAxis1st, nextAxis2nd});
                }
            }
        }

    }
}
