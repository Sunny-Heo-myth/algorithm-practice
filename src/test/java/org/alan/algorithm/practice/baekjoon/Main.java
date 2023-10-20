package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.cumulativesumstep.BJ11660;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ11660 instance = new BJ11660();
        IOUtil.answer(s -> {
            String[] ss = s.split(" ");
            return Integer.parseInt(ss[0]) + Integer.parseInt(ss[1]);
        }, instance::solve);
    }


}
