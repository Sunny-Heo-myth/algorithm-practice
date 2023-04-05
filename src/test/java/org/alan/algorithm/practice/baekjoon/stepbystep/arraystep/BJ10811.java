package org.alan.algorithm.practice.baekjoon.stepbystep.arraystep;

import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class BJ10811 {
    private final int[] array;

    public BJ10811(String input) {
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");

        array = new int[Integer.parseInt(firstLine[0])];
        int n = Integer.parseInt(firstLine[1]);

        int i = 0;
        while (i < n) {
            String[] line = lines[i + 1].split(" ");
            int from = Integer.parseInt(line[0]) - 1;
            int to = Integer.parseInt(line[1]) - 1;

            int x = 0;
            for (int j = from; j < (to - from)/2; j++) {
                int tmp = array[j];
                array[j] = array[to - x++];
                array[to - x] = tmp;
            }

            i++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i).append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static void main(String[] args) throws IOException {
        String input = IOUtil.readFiniteLine(firstLine -> Integer.parseInt(firstLine.split(" ")[1]));
        System.out.print(new BJ10811(input));
    }
}
