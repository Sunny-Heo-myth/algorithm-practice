package practice.challenges.SNU2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SufferingOfFive {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += Math.pow(Integer.parseInt(Character.toString(input.charAt(i))), 5);
        }
        System.out.println(sum);
    }
}
