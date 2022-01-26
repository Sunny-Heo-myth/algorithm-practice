package baekjoon.java.javaSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[][] inputs = new String[n][2];
        for (int i = 0; i < n; i++) {
            String[] string = bf.readLine().split(" ");
            inputs[i][0] = string[0];
            inputs[i][1] = string[1];
        }

        solution(inputs);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(inputs[i][0]).append(" ").append(inputs[i][1]).append("\n");
        }
        System.out.print(sb);
    }

    public static void solution(String[][] input) {

        // Arrays.sort(targetArray, Comparator<? super T> c)
        // Comparator function return Signed Integer and by the value interchange two element

        Arrays.sort(input, Comparator.comparingInt(strings -> Integer.parseInt(strings[0])));

//        Arrays.sort(input, (strings1, strings2) -> {
//            return Integer.parseInt(strings1[0]) - Integer.parseInt(strings2[0]);
//        });
    }

}
