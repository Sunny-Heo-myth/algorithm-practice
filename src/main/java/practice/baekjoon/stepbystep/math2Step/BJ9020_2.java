package practice.baekjoon.stepbystep.math2Step;

import java.util.Scanner;
class BJ9020_2 {
    public static void main(String[] z) {
        Scanner s = new Scanner(System.in);
        int i=0, x=0, y=0;
        for(; i++<3; x ^= s.nextInt(), y ^= s.nextInt());
        System.out.print(x+" "+y);
    }
}