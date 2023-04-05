package org.alan.algorithm.practice.baekjoon.stepbystep.arraystep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class BJ5597_2 {
    public static void main(String[] args) throws Exception {

        List<String> checkList = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 30; i++) {
            checkList.add(String.valueOf(i));
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 28; i++) {
            checkList.remove(bufferedReader.readLine());
        }

        List<String> sortedList = checkList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedList.get(0));
        System.out.println(sortedList.get(1));
    }
}
