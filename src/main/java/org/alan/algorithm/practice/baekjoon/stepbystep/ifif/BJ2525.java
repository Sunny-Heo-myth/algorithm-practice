package org.alan.algorithm.practice.baekjoon.stepbystep.ifif;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2525 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] time = bf.readLine().split(" ");
        String elapsedTime = bf.readLine();
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        int elapsedMinute = Integer.parseInt(elapsedTime);
        int sumMinute = minute + elapsedMinute;

        if (sumMinute >= 60) {
            hour += sumMinute / 60;
            minute = sumMinute % 60;
        }
        else {
            minute = sumMinute;
        }

        if (hour >= 24) {
            hour -= 24;
        }
        System.out.print(hour + " " + minute);
    }
}
