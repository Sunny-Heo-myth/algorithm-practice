package baekjoon.java.javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1000 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int first = Integer.parseInt(input.split(" ")[0]);
        int second = Integer.parseInt(input.split(" ")[1]);
        System.out.println(first + second);
    }
}
