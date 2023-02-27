package practice.baekjoon.stepbystep.iostep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ11382 {
    private final String input;

    public BJ11382(String input) {
        this.input = input;
    }

    public String answer() {
        long sum = Arrays.stream(input.split(" ")).mapToLong(Long::parseLong).reduce(Long::sum).orElse(Long.MIN_VALUE);
        return String.valueOf(sum);
    }

    public static void main(String[] args) throws IOException {
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        BJ11382 instance = new BJ11382(input);
        System.out.print(instance.answer());
    }
}
