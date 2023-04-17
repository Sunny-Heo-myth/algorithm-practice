package org.alan.algorithm.practice.baekjoon.stepbystep.arraystep;

import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class BJ10811 {
    private final int[] baskets;
    private final int[][] processList;

    public BJ10811(String input) {
        // todo: initiate array
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        baskets = new int[Integer.parseInt(firstLine[0])];
        for (int i = 0; i < baskets.length; i++) {
            baskets[i] = i + 1;
        }
        processList = new int[Integer.parseInt(firstLine[1])][2];
        for (int i = 0; i < processList.length; i++) {
            String[] line = lines[i + 1].split(" ");
            int from = Integer.parseInt(line[0]) - 1;
            int to = Integer.parseInt(line[1]);
            processList[i] = new int[]{from, to};
        }

        // todo: process the array
        for (int i = 0; i < processList.length; i++) {
            process(processList[i]);
        }
    }

    private void process(int[] ints) {
        for (int i = 0; i < (ints[1] - ints[0]) / 2; i++) {
            int temp = baskets[ints[0] + i];
            baskets[ints[0] + i] = baskets[ints[1] - i - 1];
            baskets[ints[1] - i - 1] = temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : baskets) {
            sb.append(i).append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static void main(String[] args) throws IOException {
        String input = IOUtil.readFiniteLine(firstLine -> Integer.parseInt(firstLine.split(" ")[1]));
        System.out.print(new BJ10811(input));
    }
}
