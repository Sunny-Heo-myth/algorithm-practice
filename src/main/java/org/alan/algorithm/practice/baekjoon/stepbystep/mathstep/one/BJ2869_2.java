package org.alan.algorithm.practice.baekjoon.stepbystep.mathstep.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2869_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bf.readLine().split(" ");
        int[] input = new int[3];
        for (int i = 0; i < 3; i++) {
            input[i] = Integer.parseInt(strings[i]);
        }

        Snail snail = new Snail(input[0], input[1]);
        int count = 0;
        while (snail.getAccumulated() < input[2]) {
            count++;
            snail.day();
            if (snail.getAccumulated() >= input[2]) {
                break;
            }
            snail.night();
        }
        System.out.println(count);
    }
}

class Snail {

    private int dayClimbUp;
    private int nightFallDown;
    private int accumulated = 0 ;

    public Snail(int dayUp, int nightDown) {
        this.dayClimbUp = dayUp;
        this.nightFallDown = nightDown;
    }

    public int getDayClimbUp() {
        return dayClimbUp;
    }

    public int getNightFallDown() {
        return nightFallDown;
    }

    public int getAccumulated() {
        return accumulated;
    }

    void day() {
        accumulated += dayClimbUp;
    }

    void night() {
        accumulated -= nightFallDown;
    }
}
