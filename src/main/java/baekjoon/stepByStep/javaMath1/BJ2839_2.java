package baekjoon.stepByStep.javaMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2839_2 {

    public static void main(String[] args) throws IOException {
        int x = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int box = 0;
        while (true) {
            if (x % 5 == 0) {box += x / 5; break;}
            x -= 3; box++;
            if (x < 0 ) {box = -1; break;}
        }
        System.out.print(box);
    }
}
