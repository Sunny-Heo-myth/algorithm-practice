package baekjoon.stepByStep.javaMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1978_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] x = Arrays.stream(bf.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

//        int count = 0;
//        Map<Integer, Long> map = Arrays.stream(x)
//                .filter(i -> i != 1)
//                .forEach(i -> IntStream.range(2, i)
//                    .filter(j -> i%j == 0)
//                    .collect(Collectors.groupingBy(i, )));
//        System.out.println(count);
    }
}
