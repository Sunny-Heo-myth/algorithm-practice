package practice.baekjoon.stepbystep.setandmapstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BJ1269 {
    private final Set<Integer> set1;
    private final Set<Integer> set2;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine() + "\n" + bf.readLine() + "\n" +bf.readLine();
        BJ1269 instance = new BJ1269(input);
        System.out.print(instance.answer());
    }

    public BJ1269(String input) {
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        String[] lines = input.split("\n");
        Arrays.stream(lines[1].split(" ")).mapToInt(Integer::parseInt).forEach(set1::add);
        Arrays.stream(lines[2].split(" ")).mapToInt(Integer::parseInt).forEach(set2::add);
    }

    public long answer() {
        long x = set1.stream().filter(i1 -> !set2.contains(i1)).count();
        long y = set2.stream().filter(i2 -> !set1.contains(i2)).count();
        return x + y;
    }
}
