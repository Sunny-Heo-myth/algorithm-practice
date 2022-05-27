package com.baekjoonPractice.stepByStep.math1Step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2869 {

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader
            (new InputStreamReader(System.in)).readLine(), " ");

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());
        double doubleDay = (double) (destination - up)/(up - down);
        int intday = (destination - up)/(up - down);
        if (up >= destination) System.out.print(1);
        else if (doubleDay - intday == 0.0) System.out.print(intday + 1);
        else System.out.print(intday + 2);
    }
}
