package practice.baekjoon.stepbystep.arrayStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ10818 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        for (int i : array) {
            if (i <= minimum) minimum = i;
            if (i >= maximum) maximum = i;
        }
        System.out.println(minimum + " " + maximum);
    }
}
