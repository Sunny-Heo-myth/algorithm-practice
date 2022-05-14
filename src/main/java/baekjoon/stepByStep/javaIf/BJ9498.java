package baekjoon.stepByStep.javaIf;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9498 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bf.readLine());
        bf.close();
        if (input <= 100 && input >= 90) System.out.println("A");
        else if (input <= 89 && input >= 80) System.out.println("B");
        else if (input <= 79 && input >= 70) System.out.println("C");
        else if (input <= 69 && input >= 60) System.out.println("D");
        else System.out.println("F");

    }
}
