package org.alan.algorithm.practice.baekjoon.stepbystep.forstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ25304 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        sb.append(bf.readLine()).append("\n");
        String numberOfLines = bf.readLine();
        sb.append(numberOfLines).append("\n");

        for (int i = 0; i < Integer.parseInt(numberOfLines); i++) {
            sb.append(bf.readLine()).append("\n");
        }
        System.out.print(new BJ25304().solve(sb.toString()));
    }

    public String solve(String input) {
        String[] lines = input.split("\n");
        int totalPrice = Integer.parseInt(lines[0]);
        int kinds = Integer.parseInt(lines[1]);
        int sum = 0;
        for (int i = 0; i < kinds; i++) {
            String[] line = lines[i + 2].split(" ");
            sum += (Integer.parseInt(line[0]) * Integer.parseInt(line[1]));
        }
        return sum == totalPrice ? "Yes" : "No";
    }
}
