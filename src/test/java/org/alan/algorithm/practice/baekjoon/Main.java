package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.deepone.BJ2444;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int i = Integer.parseInt(IOUtil.readFiniteLine(s->0));
        BJ2444 instance = new BJ2444();
        String answer = instance.solve(i);
        System.out.print(answer);
    }

}
