package baekjoon.javaString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ5622 {

    public static void main(String[] args) throws IOException {
        char[] chars = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
        int count = 0;
        for (char ch : chars) {
            if (ch < 68) count += 3;
            else if (ch < 71) count += 4;
            else if (ch < 74) count += 5;
            else if (ch < 77) count += 6;
            else if (ch < 80) count += 7;
            else if (ch < 84) count += 8;
            else if (ch < 87) count += 9;
            else if (ch < 91) count += 10;
        }
        System.out.print(count);

    }
}
