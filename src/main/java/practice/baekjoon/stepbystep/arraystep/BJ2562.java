package practice.baekjoon.stepbystep.arraystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2562 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < 9; i++) {
            int now = Integer.parseInt(bf.readLine());
            if (max <= now) {
                max = now;
                index = i + 1;
            }
        }
        System.out.println(max + "\n" + index);
    }
}
