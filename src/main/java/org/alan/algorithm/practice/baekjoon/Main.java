package org.alan.algorithm.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int n = S.length();
        int q = Integer.parseInt(br.readLine());

        int[][] count = new int[26][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) count[j][i + 1] = count[j][i];
            count[S.charAt(i) - 'a'][i + 1]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char alpha = (char) (st.nextToken().charAt(0) - 'a');
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int result = count[alpha][r + 1] - count[alpha][l];
            sb.append(result).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
