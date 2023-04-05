package org.alan.algorithm.practice.baekjoon.stepbystep.backtrackingstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14889 {
    static int n;
    static int[][] ability;
    static int[] team1;
    static int[] team2;
    static boolean[] teamCheck;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        ability = new int[n][n];
        team1 = new int[n/2];
        team2 = new int[n/2];
        teamCheck = new boolean[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < n; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0);
        System.out.print(min);
    }

    static void solution(int count) {
        if (count == n/2) {
            int sum1 = 0;
            int[][] pairs1 = pickingTwo(team1);
            for (int i = 0; i < pairs1.length; i++) {
                sum1 += (ability[pairs1[i][0]][pairs1[i][1]] + ability[pairs1[i][1]][pairs1[i][0]]);
            }

            int sum2 = 0;
            int team2Index = 0;
            for (int i = 0; i < n; i++) {
                int in = 0;
                for (int j = 0; j < n/2; j++) {
                    if (team1[j] == i) {
                        in++;
                    }
                }
                if (in == 0) {
                    team2[team2Index] = i;
                    team2Index++;
                }
            }
            int[][] pairs2 = pickingTwo(team2);
            for (int i = 0; i < pairs2.length; i++) {
                sum2 += (ability[pairs2[i][0]][pairs2[i][1]] + ability[pairs2[i][1]][pairs2[i][0]]);
            }

            int answer = Math.abs(sum1 - sum2);
            if (answer < min) {
                min = answer;
            }
            return;

        }

        for (int i = count; i < n; i++) {
            if (!teamCheck[i]) {
                teamCheck[i] = true;
                team1[count] = i;
                solution(count + 1);
                teamCheck[i] = false;
            }
        }

    }

    static int[][] pickingTwo(int[] team) {
        int length = team.length;
        int cases = length*(length - 1)/2;
        int [][] result = new int[cases][2];
        int index = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                result[index][0] = team[i];
                result[index][1] = team[j];
                index++;
            }
        }
        return result;
    }

}
