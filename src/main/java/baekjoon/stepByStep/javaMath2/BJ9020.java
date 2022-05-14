package baekjoon.stepByStep.javaMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9020 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(bf.readLine());
            int half = x/2;

            targetLoop :
            for (int j = half; j < x; j++) {
                int first = x - j;
                int second = j;
                int countFirst = 0;
                int countSecond = 0;
                for (int devisor = 2; devisor < first; devisor++) {
                    if (first%devisor == 0) break;
                    else countFirst++;
                }
                for (int devisor = 2; devisor < second; devisor++) {
                    if (second%devisor == 0) break;
                    else countSecond++;
                }
                if (countFirst == first - 2 && countSecond == second - 2) {
                    sb.append(first).append(" ").append(second).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}
