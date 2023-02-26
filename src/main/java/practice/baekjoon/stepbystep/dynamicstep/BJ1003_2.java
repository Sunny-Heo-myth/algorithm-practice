package practice.baekjoon.stepbystep.dynamicstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1003_2 {
    static int zeroCount = 0;
    static int oneCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            fibo(Integer.parseInt(bf.readLine()));
            sb.append(zeroCount).append(" ").append(oneCount).append("\n");
            zeroCount = 0;
            oneCount = 0;
        }
        System.out.print(sb);
    }

    static int fibo(int x) {
        if (x == 0) {
            zeroCount++;
            return 0;
        } else if (x == 1) {
            oneCount++;
            return 1;
        }

        return  fibo(x - 1) + fibo(x - 2);
    }
}
