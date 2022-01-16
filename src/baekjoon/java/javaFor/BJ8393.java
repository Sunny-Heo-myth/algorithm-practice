package baekjoon.java.javaFor;

import java.util.Scanner;

public class BJ8393 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int y = 0;
        for (int i = 1; i <= n; i++) y+=i;
        System.out.println(y);
    }

}
