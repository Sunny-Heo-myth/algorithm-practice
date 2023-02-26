package practice.baekjoon.stepbystep.math2step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2581 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());

        int count = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = m; i < n + 1; i++) {
            if (i == 1) continue;

            int factor = 0;
            int j = 2;
            while (j < i) {
                if (i%j == 0) break;
                else factor++;
                j++;
            }
            if (factor == i - 2) {
                count++;
                sum += i;
                if (min > i) min = i;
            }
        }
        if (count == 0) System.out.println(-1);
        else System.out.println(sum + "\n" + min);
    }
}
