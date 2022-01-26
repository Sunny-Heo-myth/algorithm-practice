package baekjoon.java.javaMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1978 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] x = Arrays.stream(bf.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int count = 0;
        for (int i : x) {
            if (i == 1) continue;
            int count2 = 0;
            int j = 2;
            while (j != i) {
                if (i % j == 0) break;
                else count2++;
                j++;
            }
            if (count2 == i - 2) count++;
        }
        System.out.println(count);
    }
}
