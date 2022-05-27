package com.baekjoonPractice.stepByStep.backTrackingStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14889_2 {
    static int n;
    static int[][] ability;
    static boolean[] teamCheck;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        ability = new int[n][n];
        teamCheck = new boolean[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < n; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0,0);
        System.out.print(min);
    }

    static void solution(int startIndex, int count) {
        if (count == n / 2) {
            difference();
            return;

        }

        for (int i = startIndex; i < n; i++) {
            if (!teamCheck[i]) {
                teamCheck[i] = true;
                solution(i + 1, count + 1);
                teamCheck[i] = false;
            }
        }

    }

    static void difference() {
        int team1score = 0;
        int team2score = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (teamCheck[i] && teamCheck[j]) {
                    team1score += (ability[i][j] + ability[j][i]);
                } else if (!teamCheck[i] && !teamCheck[j]) {
                    team2score += (ability[i][j] + ability[j][i]);
                }
            }
        }

        int answer = Math.abs(team1score - team2score);
        if (answer == 0) {
            System.out.println(0);
            System.exit(0);
        }
        min = Math.min(min, answer);
    }

}
