package baekjoon.stepByStep.javaString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            char[] chars = bf.readLine().toCharArray();
            boolean[] booleans = new boolean[26];
            char previousCh = 0;
            int check = 0;
            for (char ch : chars) {
                if (!booleans[ch - 97]) booleans[ch - 97] = true;
                else if (previousCh != ch) break;
                check++;
                previousCh = ch;
            }
            if(check == chars.length) count++;
        }
        System.out.print(count);
    }
}
