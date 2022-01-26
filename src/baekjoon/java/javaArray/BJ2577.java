package baekjoon.java.javaArray;


import java.util.Scanner;

public class BJ2577 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt() * sc.nextInt() * sc.nextInt();
        String string = Integer.toString(x);
        int length = string.length();
        int[] count = new int[10];
        for (int i = 0; i < length; i++) count[Character.getNumericValue(string.charAt(i))]++;
        StringBuilder sb = new StringBuilder();
        for (int i : count) sb.append(i).append("\n");
        System.out.print(sb);
    }
}
