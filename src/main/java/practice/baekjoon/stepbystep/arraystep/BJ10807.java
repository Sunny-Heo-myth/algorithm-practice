package practice.baekjoon.stepbystep.arraystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ10807 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bf.readLine();
        String s = bf.readLine();
        int x = Integer.parseInt(bf.readLine());
        long answer = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .filter(i -> i == x)
                .count();
        System.out.print(answer);
    }
}
