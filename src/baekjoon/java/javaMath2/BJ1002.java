package baekjoon.java.javaMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1002 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int[] x = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            double centerToCenter = Math.pow(Math.pow((x[0] - x[3]), 2) + Math.pow((x[1] - x[4]), 2), 0.5);
            int distance = x[2] + x[5];

            if (centerToCenter < distance) {

                if (centerToCenter == 0) {

                    if (x[2] == x[5]) sb.append(-1);
                    else sb.append(0);
                }
                else {

                    if (centerToCenter == Math.abs(x[2] - x[5])) sb.append(1);
                    else if (centerToCenter < Math.abs(x[2] - x[5])) sb.append(0);
                    else sb.append(2);
                }
            }
            else if (centerToCenter > distance) sb.append(0);
            else sb.append(1);

            sb.append("\n");
        }
        System.out.print(sb);
    }

}
