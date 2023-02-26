package practice.baekjoon.stepbystep.math1step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10757_2 {
    private final int[] x;
    private final int[] y;
    private final int[] z;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BJ10757_2 instance = new BJ10757_2(bf.readLine());
        System.out.print(instance.answer());
    }
    public BJ10757_2(String input) {
        String[] line = input.split(" ");

        char[] a = line[0].toCharArray();
        char[] b = line[1].toCharArray();

        int maxLength = Math.max(a.length, b.length) + 1;
        x = new int[maxLength];
        for (int i = 0; i < a.length; i++) {
            x[maxLength - (i + 1)] = Integer.parseInt(String.valueOf(a[a.length - (i + 1)]));
        }

        y = new int[maxLength];
        for (int i = 0; i < b.length; i++) {
            y[maxLength - (i + 1)] = Integer.parseInt(String.valueOf(b[b.length - (i + 1)]));
        }

        z = new int[maxLength];
    }

    public String answer() {
        int overflow = 0;
        for (int i = x.length - 1; i >= 0; i--) {
            int sum = x[i] + y[i] + overflow;
            if (sum > 9) {
                z[i] = sum - 10;
                overflow = 1;
            } else {
                z[i] = sum;
                overflow = 0;
            }
        }
        return toString();
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int j : z) {
            sb.append(j);
        }

        for (int j : z) {
            if (j == 0) {
                sb.deleteCharAt(0);
            } else {
                break;
            }
        }
        return sb.toString();
    }

}
