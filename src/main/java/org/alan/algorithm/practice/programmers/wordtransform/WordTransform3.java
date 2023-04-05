package org.alan.algorithm.practice.programmers.wordtransform;

public class WordTransform3 {
    private boolean[] visited;
    private int answer = 0;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);
        return answer;
    }

    private void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            answer = count;
            return;
        }

        for (int i = 0; i< words.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (compare(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }

        }
    }

    private boolean compare(String word1, String word2) {
        int wordLength = word1.length();
        int unMatch = 0;
        int i = 0;
        while (i < wordLength) {
            if (word1.charAt(i) != word2.charAt(i)) {
                unMatch++;
            }
            if (unMatch > 1) {
                break;
            }
            i++;
        }
        return unMatch == 1;
    }
}
