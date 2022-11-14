package practice.baekjoon.stepbystep.math2Step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ4153 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int[] ints = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            if (ints[0] == 0 && ints[1] == 0 && ints[2] == 0) break;

            int[] sortedInts = Arrays.stream(ints)
                .sorted()
                .toArray();

            if (Math.pow(sortedInts[0], 2) + Math.pow(sortedInts[1], 2) == Math.pow(sortedInts[2], 2))
                sb.append("right").append("\n");
            else sb.append("wrong").append("\n");
        }
        System.out.print(sb);
    }

}
