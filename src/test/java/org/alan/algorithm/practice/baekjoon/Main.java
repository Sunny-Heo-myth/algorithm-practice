package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.cumulativesumstep.BJ11659;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ11659 instance = new BJ11659();
        IOUtil.answer(input -> Integer.parseInt(input.split(" ")[1]) + 1, instance::solve2);
    }

}
