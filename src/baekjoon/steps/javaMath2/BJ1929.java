package baekjoon.steps.javaMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1929 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bf.readLine().split(" ");
        int[] ints = {Integer.parseInt(strings[0]), Integer.parseInt(strings[1])};

        boolean[] booleans = new boolean[ints[1]];
        booleans[0] = true;
        StringBuilder sb = new StringBuilder();

        int i = 2;
        while (i <= ints[1] / 2) {
            int j = 2;
            while (i*j <= ints[1]) {
                booleans[i*j - 1] = true;
                j++;
            }
            i++;
        }
        for (int k = ints[0] - 1; k < ints[1]; k++) if (!booleans[k]) sb.append(k + 1).append("\n");
        System.out.print(sb);
    }


}
