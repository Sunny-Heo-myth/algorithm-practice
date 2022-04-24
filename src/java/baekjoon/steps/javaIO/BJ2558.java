package baekjoon.steps.javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ2558 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(Integer.parseInt(bf.readLine()) + Integer.parseInt(bf.readLine()));
    }
}
