package baekjoon.java.javaMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2839 {

    public static void main(String[] args) throws IOException {
        int x = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int bag5kg = 0, min = Integer.MAX_VALUE;
        while (5 * bag5kg <= x) {
            int remainder5kg = x - 5 * bag5kg;
            int bag3kg = remainder5kg / 3;
            if (remainder5kg % 3 == 0 && (bag5kg + bag3kg) < min) min = bag5kg + bag3kg;
            bag5kg++;
        }
        if (min == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(min);
    }
}
