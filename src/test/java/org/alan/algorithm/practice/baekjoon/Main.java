package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.stringstep.BJ11718;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ11718 instance = new BJ11718();
        String s = IOUtil.answer(instance::solve);
        System.out.print(s);
    }

}
