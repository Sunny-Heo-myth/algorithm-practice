package baekjoon.steps.javaArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ8958 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String now = bf.readLine();
            int length = now.length();
            char[] charArray = now.toCharArray();
            int count = 0;
            int sum = 0;
            for (char c : charArray) {
                if (c == 'O') {
                    count++;
                    sum += count;
                } else count = 0;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
