package practice.baekjoon.stepbystep.recursionstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ25501 {

    public static void main(String[] args) throws IOException {
        BJ25501 instance = new BJ25501();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (count < cases) {
            String input = bf.readLine();
            sb.append(instance.recursion(input)).append(" ").append(input.length());
            count++;
        }
        System.out.println(sb);

    }

    public boolean isPalindrome(String input) {
        return recursion(input) == 1;
    }

    public int recursion(String input) {

        if (input.charAt(0) != input.charAt(input.length() - 1)) {
            return 0;
        }

        if (input.length() >= 3) {
            recursion(input.substring(1, input.length() - 1));
        }

        return 1;
    }
}
