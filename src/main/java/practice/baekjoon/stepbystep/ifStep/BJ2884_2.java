package practice.baekjoon.stepbystep.ifStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2884_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        int hour = Integer.parseInt(inputs[0]);
        int minute = Integer.parseInt(inputs[1]);

        if (hour == 0 && minute < 45) {
            System.out.print("23 " + (minute + 15));
        }
        else if (minute < 45) {
            System.out.print((hour - 1) + " " + (minute + 15));
        }
        else {
            System.out.println(hour + " " + (minute - 45));
        }
    }
}
