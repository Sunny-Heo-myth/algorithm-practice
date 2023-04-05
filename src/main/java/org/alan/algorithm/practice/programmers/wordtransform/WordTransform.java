package org.alan.algorithm.practice.programmers.wordtransform;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class WordTransform {
    private String[] words;
    private boolean[][] matrix;
    private int targetIndex;

    public int solution(String begin, String target, String[] words) {
        if (!checkWords(target)) {
            return 0;
        }

        this.words = words;
        setMatrix(begin);
        return iterate();
    }

    private boolean checkWords(String target) {
        for (int i = 0; i < words.length; i++) {
            if (Objects.equals(words[i], target)) {
                targetIndex = i;
                return true;
            }
        }
        return false;
    }

    private void setMatrix(String begin) {
        int length = words.length + 1;
        matrix = new boolean[length][length];

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (compare(words[i], words[j])) {
                    matrix[i][j] = true;
                }
            }
            if (compare(words[i], begin)) {
                matrix[i][words.length] = true;
            }
        }
    }

    private boolean compare(String word1, String word2) {
        int wordLength = word1.length();
        int unMatch = 0;
        int i = 0;
        while (unMatch < 2 && i < wordLength) {
            if (word1.charAt(i) != word2.charAt(i)) {
                unMatch++;
            }
            i++;
        }
        return unMatch < 2;
    }

    private int iterate() {
        Queue<int[]> queue = new LinkedList<>();
        int travel = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][words.length]) {
                queue.add(new int[]{i, words.length, travel});
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            if (node[0] == targetIndex) {
                return travel;
            }

            for (int i = 0; i < matrix.length; i++) {
                if (matrix[node[0]][i]) {
                    queue.add(new int[]{node[0], i, travel});
                }

            }


        }
        return 0;
    }

}
