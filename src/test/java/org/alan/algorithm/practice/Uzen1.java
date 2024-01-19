package org.alan.algorithm.practice;

import java.util.stream.IntStream;

public class Uzen1 {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 1000).filter(i -> i % 2 == 1).sum();
        System.out.println("홀수의 합: " + sum);

    }

}
