package org.alan.algorithm.practice.baekjoon.stepbystep.array;

import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class BJ10813 {
    private final int[] array;

    public BJ10813(String input) {
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        array = new int[Integer.parseInt(firstLine[0])];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        int i = 0;
        while (i < Integer.parseInt(firstLine[1])) {
            String[] line = lines[i + 1].split(" ");
            int fromIndex = Integer.parseInt(line[0]) - 1;
            int toIndex = Integer.parseInt(line[1]) - 1;
            int tmp = array[fromIndex];
            array[fromIndex] = array[toIndex];
            array[toIndex] = tmp;
            i++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int j : array) {
            sb.append(j).append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static void main(String[] args) throws IOException {
        String input = IOUtil.readFiniteLine(firstLine -> Integer.parseInt(firstLine.split(" ")[1]));
        BJ10813 instance = new BJ10813(input);
        System.out.print(instance);
    }
}
