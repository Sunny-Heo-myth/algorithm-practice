package baekjoon.stepByStep.javaMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11653 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        while (m > 1) {
            for (int i = 2; i <= m; i++) {
                if (m%i == 0) {
                    m /= i;
                    sb.append(i).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
