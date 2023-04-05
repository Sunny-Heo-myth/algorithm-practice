package org.alan.algorithm.practice.programmers.sichuancastle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Programmers1836_2 {

    public static void main(String[] args) {
        String[] board = {".ZI.",
                          "M.**",
                          "MZU.",
                          ".IU."};
        String[] board2 = {"DBA", "C*A", "CDB"};
        String[] board3 = {"NRYN", "ARYA"};
        String[] board4 = {"AB", "BA"};
        String[] board5 = {"M...M...DU", "....AR...R", "...E..OH.H", ".....O....", ".E..A..Q..",
            "Q....LL.*.", ".D.N.....U", "GT.T...F..", "....FKS...", "GN....K..S"};
        String[] board6 = {"ABC.CBA"};
        String[] board7 = {"A", "B", "E", "E", "B", "A"};
            System.out.println(solution(10, 10, board5));
    }

    // 1. make char[][] & count work list.
    // 2. one by one, compare char with nextChar
    // 3. If char == nextChar : check if it is *****deletable*****
    // 4. Among deletable, delete with first order char & change two block into "."
    //      & put it in the result & work list--
    // 5. loop 2. ~ 4. until there is no deletable left
    // 6. If workList != 0, print Impossible.

    static String solution(int m, int n, String[] board) {
        char[][] chars = new char[m][n];
        List<Block> workable = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            chars[i] = board[i].toCharArray();
            for (int j = 0; j < n; j++) {
                char nowChar = chars[i][j];
                if (nowChar != 46 && nowChar != 42) workable.add(new Block(i, j, nowChar));
            }
        }
        int size = workable.size()/2;
        StringBuilder answer = new StringBuilder();
        while (true) {
            ArrayList<Block> deletable = new ArrayList<>();

            for (Block nowBlock : workable) for (Block nextBlock : workable) {
                if ((nowBlock.x != nextBlock.x || nowBlock.y != nextBlock.y) &&
                    nowBlock.aChar == nextBlock.aChar &&
                    deletable(charsCopy(chars, nowBlock.x, nowBlock.y, nextBlock.x, nextBlock.y))) {

                    deletable.add(nowBlock);
                    deletable.add(nextBlock);
                    break;
                }
            }
            if (deletable.isEmpty()) break;

            char deletableChar = 128;
            Block block = null;
            Block nextBlock = null;
            for (int i = 0; i < deletable.size(); i += 2) {
                Block instantBlock = deletable.get(i);
                Block instantNextBlock = deletable.get(i + 1);
                if (deletableChar > instantBlock.aChar) {
                    deletableChar = instantBlock.aChar;
                    block = instantBlock;
                    nextBlock = instantNextBlock;
                }
            }
            assert block != null;
            chars[block.x][block.y] = '.';
            assert nextBlock != null;
            chars[nextBlock.x][nextBlock.y] = '.';
            workable.remove(block);
            workable.remove(nextBlock);

            answer.append(deletableChar);
        }

        if (size != answer.length()) return "IMPOSSIBLE";

        return answer.toString();
    }

    static boolean deletable(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        int distance = m + n - 3;
        int i = 0, iCount = 0;
        while (i < distance) {
            int move = i + 1;
            if (move < m && box[move][0] == '.') iCount++;
            if (move >= m && box[m - 1][move - m + 1] == '.') iCount++;
            i++;
        }
        if (iCount == distance) return true;

        int j = 0, jCount = 0;
        while (j < distance) {
            int move = j + 1;
            if (move < n && box[0][move] == '.') jCount++;
            if (move >= n && box[move - n + 1][n - 1] == '.') jCount++;
            j++;
        }
        if (jCount == distance) return true;

        return false;
    }

    static char[][] charsCopy(char[][] chars, int nowX, int nowY, int nextX, int nextY) {
        char[][] copied;

        if (nowX <= nextX && nowY <= nextY) {
            copied = new char[nextX - nowX + 1][nextY - nowY + 1];
            for (int i = 0; i < nextX - nowX + 1; i++)
                System.arraycopy(chars[nowX + i], nowY, copied[i], 0, nextY - nowY + 1);
            return copied;
        }
        else if (nowX <= nextX) {
            copied = new char[nextX - nowX + 1][nowY - nextY + 1];
            for (int i = 0; i < nextX - nowX + 1; i++)
                System.arraycopy(chars[nowX + i], nextY, copied[i], 0, nowY - nextY + 1);
            return getChars(copied);
        }
        else if (nowY <= nextY) {
            copied = new char[nowX - nextX + 1][nextY - nowY + 1];
            for (int i = nextX - nowX; i >= 0; i--)
                System.arraycopy(chars[i], nowY, copied[i], 0, nextY - nowY + 1);
            return copied;
        }
        else {
            copied = new char[nowX - nextX + 1][nowY - nextY + 1];
            for (int i = nextX - nowX; i >= 0; i--)
                System.arraycopy(chars[i], nextY, copied[i], 0, nowY - nextY + 1);
            return getChars(copied);
        }
    }

    private static char[][] getChars(char[][] copied) {
        int length = copied.length;
        int length2 = copied[0].length;
        char[][] instant = new char[length][length2];
        for(int i = 0; i < length; i++) for (int j = 0; j < length2; j++)
            instant[i][j] = copied[i][length2 - j - 1];
        return instant;
    }
}

class Block {
    int x;
    int y;
    char aChar;

    public Block() {
    }

    public Block(int x, int y, char aChar) {
        this.x = x;
        this.y = y;
        this.aChar = aChar;
    }
}
