package practice.baekjoon.stepbystep.sortstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2750 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(bf.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int temp;
                if (ints[i] > ints[j]) {
                    temp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ints[i]).append("\n");
        }
        System.out.print(sb);
    }

}
