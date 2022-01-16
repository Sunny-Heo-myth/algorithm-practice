package baekjoon.java.javaString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2675 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] x = bf.readLine().split(" ");
            int times = Integer.parseInt(x[0]);
            String string = x[1];
            sb.append(repeat(times, string)).append("\n");
        }
        System.out.println(sb);
    }

    static String repeat(int times, String string) {
        char[] chars = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) sb.append(Character.toString(chars[i]).repeat(times));
        return sb.toString();
    }
}
