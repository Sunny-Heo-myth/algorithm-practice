package practice.baekjoon.stepbystep.forstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11021_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            String[] input = bf.readLine().split(" ");
            int sum = Integer.parseInt(input[0]) + Integer.parseInt(input[1]);
            sb.append("Case #").append(i).append(": ");
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
