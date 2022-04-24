package programmers.sichuanCastle;

import java.util.Arrays;

public class Programmers1836 {

    public static void main(String[] args) {
        String[] board = {".ZI.", "M.**", "MZU.", ".IU."};
        System.out.println();
    }

    // 1. make char[][] & put different characters in work list.
    // 2. one by one, compare char with nextChar
    // 3. If char == nextChar : check if it is deletable
    // 4. Among deletable delete first order & change two block into "."
    //      & put it in the result & put out of work list
    // 5. loop 4. until there is no deletable left
    // 6. If the number of work list and result is different, print Impossible.
    public String solution(int m, int n, String[] board) {
        char[][] chars = new char[m][n];
        boolean[][] booleans = new boolean[m][n];
        for (int i = 0; i < m; i++) chars[i] = board[i].toCharArray();

        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            if (chars[i][j] == 46 || chars[i][j] == 42) booleans[i][j] = true;
        }

        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            if (booleans[i][j]) continue;

            boolean[][] instantBoolean = Arrays.copyOf(booleans, booleans.length);
            char nowChar = chars[i][j];
            for (int k = 0; k < m; k++) for (int l = 0; l < n; l++) {
                char nextChar = chars[k][l];
                if (i == k && j == l) continue;

                if (nowChar == nextChar) {

                }
            }
        }


        String answer = "";
        return answer;
    }

    static boolean deletable(int[][] box) {
        return false;
    }
}
