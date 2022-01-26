package baekjoon.java.javaIf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2753 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bf.readLine());

        if (input % 400 == 0) System.out.println(1);
        else if (input % 100 == 0) System.out.println(0);
        else if (input % 4 == 0) System.out.println(1);
        else System.out.println(0);

    }

}
