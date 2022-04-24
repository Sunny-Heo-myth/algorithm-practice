package baekjoon.steps.javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2588 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(bf.readLine());
        char[] second = bf.readLine().toCharArray();
        bf.close();
        int length = second.length;
        int zero = Integer.parseInt(Character.toString(second[length - 1])) * first;
        int one = Integer.parseInt(Character.toString(second[length - 2])) * first;
        int two = Integer.parseInt(Character.toString(second[length - 3])) * first;
        System.out.print(zero + "\n" + one + "\n" + two + "\n" + (zero + one*10 + two*100));

    }

}
