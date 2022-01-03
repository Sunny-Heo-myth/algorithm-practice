package baekjoon.javaFor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            String[] input = bf.readLine().split(" ");
            int num1st = Integer.parseInt(input[0]);
            int num2nd = Integer.parseInt(input[1]);
            int sum = num1st + num2nd;
            sb.append("Case #").append(i).append(": ")
            .append(num1st).append(" + ").append(num2nd).append(" = ").append(sum)
                .append("\n");
        }
        System.out.println(sb);
    }
}

