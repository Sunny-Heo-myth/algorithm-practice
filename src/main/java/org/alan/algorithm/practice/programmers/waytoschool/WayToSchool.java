package org.alan.algorithm.practice.programmers.waytoschool;

public class WayToSchool {
    private int m;
    private int n;
    private int[][] puddles;
    private boolean[][] map;
    private int[][] dynamicMap;

    public int solution(int m, int n, int[][] puddles) {
        this.m = m;
        this.n = n;
        this.puddles = puddles;

        drawMap();
        travel();

        return dynamicMap[m - 1][n - 1];
    }

    private void drawMap() {
        map = new boolean[m][n];
        for (int[] puddle : puddles) {
            map[puddle[0] - 1][puddle[1] - 1] = true;
        }

        dynamicMap = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (!map[i][0]) {
                dynamicMap[i][0] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!map[0][i]) {
                dynamicMap[0][i] = 1;
            }
        }
    }

    private void travel() {
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (!map[i][j]) {
                    int mod = 1000000007;
                    dynamicMap[i][j] = (dynamicMap[i-1][j] + dynamicMap[i][j-1]) % mod;
                }
            }
        }
    }

}
