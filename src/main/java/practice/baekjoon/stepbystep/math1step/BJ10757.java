package practice.baekjoon.stepbystep.math1step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10757 {

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(
            new BufferedReader(new InputStreamReader(System.in)).readLine(), " ");
        char[] a = st.nextToken().toCharArray();
        char[] b = st.nextToken().toCharArray();
        int max = Math.max(a.length, b.length);
        int[] A = new int[max + 1];
        int[] B = new int[max + 1];
        for (int i = 0; i < a.length; i++) A[i] = a[a.length - 1 - i] - '0';
        for (int i = 0; i < b.length; i++) B[i] = b[b.length - 1 - i] - '0';
        for (int i = 0; i < max; i++) {
            int sum = A[i] + B[i];
            A[i] = sum % 10;
            A[i + 1] += sum / 10;
        }
        StringBuilder sb = new StringBuilder();
        if(A[max] != 0) sb.append(A[max]);
        for(int i = max - 1; i >= 0; i--) sb.append(A[i]);
        System.out.print(sb);
    }

}
