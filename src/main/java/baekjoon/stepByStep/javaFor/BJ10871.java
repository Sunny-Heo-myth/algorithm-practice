package baekjoon.stepByStep.javaFor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10871 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);
        String[] list = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(list[i]);
            if (now < x) System.out.print(now + " ");
        }
    }
}
