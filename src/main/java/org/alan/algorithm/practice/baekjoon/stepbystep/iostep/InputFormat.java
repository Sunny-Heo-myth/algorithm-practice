package org.alan.algorithm.practice.baekjoon.stepbystep.iostep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputFormat {

    static void input2args() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int first = Integer.parseInt(input.split(" ")[0]);
        int second = Integer.parseInt(input.split(" ")[1]);
    }
}
