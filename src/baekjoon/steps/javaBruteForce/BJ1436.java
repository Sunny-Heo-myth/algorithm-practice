package baekjoon.steps.javaBruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(doom(Integer.parseInt(bf.readLine())));
    }

    static int doom(int order) {
        int doom = 666;
        int count = 0;
        while (true) {
            char[] chars = Integer.toString(doom).toCharArray();
            for (int i = 0; i < chars.length - 2; i++) {
                if (chars[i] == 54 && chars[i + 1] == 54 && chars[i + 2] == 54) {
                    count++;
                    break;
                }
            }
            if (count == order) return doom;
            doom++;
        }
    }

}
