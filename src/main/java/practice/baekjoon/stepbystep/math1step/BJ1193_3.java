package practice.baekjoon.stepbystep.math1step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1193_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bf.readLine());

        int row = 1;
        while (input > 0) {
            input -= row;
            row++;
        }
        int remnant = input + row - 1;

        if (row % 2 == 1) {
            System.out.print(remnant + "/" + (row - remnant));
        }
        else {
            System.out.print((row - remnant) + "/" + remnant);
        }


    }
}
