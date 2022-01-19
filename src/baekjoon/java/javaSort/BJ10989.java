package baekjoon.java.javaSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] ints = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(bf.readLine());
        }

        int[] countingArray = new int[10000];
        for (int i : ints) {
            countingArray[i - 1]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < countingArray[i]; j++) {
                sb.append(i + 1).append("\n");
            }
        }
        System.out.print(sb);
    }
}
