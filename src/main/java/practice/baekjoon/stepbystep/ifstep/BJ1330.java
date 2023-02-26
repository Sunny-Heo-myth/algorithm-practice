package practice.baekjoon.stepbystep.ifstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1330 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int leftNum = Integer.parseInt(input[0]);
        int rightNum = Integer.parseInt(input[1]);
        if (leftNum < rightNum) System.out.print("<");
        else if (leftNum > rightNum) System.out.print(">");
        else System.out.println("==");
    }

}
