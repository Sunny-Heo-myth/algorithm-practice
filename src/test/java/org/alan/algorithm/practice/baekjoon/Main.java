package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedeque.BJ10773;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ10773 instance = new BJ10773();
        String input = IOUtil.readFiniteLine(Integer::parseInt);
        System.out.print(instance.solve(input));
    }

}
