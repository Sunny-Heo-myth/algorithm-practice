package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.topic.geometry.BJ11758;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ11758 instance = new BJ11758();
        IOUtil.answer(2, instance::solve);
    }


}
