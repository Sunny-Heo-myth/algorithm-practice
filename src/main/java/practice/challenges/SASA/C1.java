package practice.challenges.SASA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        String[] list = bf.readLine().split(" ");

        List<Integer> intList = Arrays.stream(list)
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        intList.stream()
                .forEach(s -> System.out.println(s));

        //stream is not for array with primitives.
//        int[] intList = Arrays.stream(list)
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
    }
}
