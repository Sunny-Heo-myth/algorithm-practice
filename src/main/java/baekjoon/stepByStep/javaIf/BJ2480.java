package baekjoon.stepByStep.javaIf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int first = Integer.parseInt(input[0]);
        int second = Integer.parseInt(input[1]);
        int third = Integer.parseInt(input[2]);

        if (first == second && second == third) {
            System.out.println(10000 + first * 1000);
        }
        else if (first == second && second != third) {
            System.out.println(1000 + first * 100);
        }
        else if (first == third && second != third) {
            System.out.println(1000 + first * 100);
        }
        else if(second == third && first != third) {
            System.out.println(1000 + second * 100);
        }
        else {
            System.out.println(
                    Math.max(first, Math.max(second, third)) * 100
            );
        }
    }
}
