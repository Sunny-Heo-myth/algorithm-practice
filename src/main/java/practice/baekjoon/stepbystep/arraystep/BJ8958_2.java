package practice.baekjoon.stepbystep.arraystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ8958_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(bf.readLine());
        int[] scores = new int[cases];
        for (int i = 0; i < cases; i++) {
            char[] chars = bf.readLine().toCharArray();
            int score = 0;
            int continuous = 0;
            for (char ch : chars) {
                if (ch == 'O') {
                    continuous++;
                    score += continuous;
                }
                else {
                    continuous = 0;
                }
            }
            scores[i] = score;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < cases) {
            sb.append(scores[i]).append('\n');
            i++;
        }
        System.out.print(sb);
    }
}
