package practice.baekjoon.stepbystep.arraystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class BJ10810 {
    private final int[] basket;

    public BJ10810(String input) {
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        basket = new int[parseInt(firstLine[0])];

        for (int i = 0; i < parseInt(firstLine[1]); i++) {
            String[] line = lines[i + 1].split(" ");
            int from = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);
            int ballNumber = Integer.parseInt(line[2]);
            put(from, to, ballNumber);
        }

    }

    private void put(int from, int to, int ballNumber) {
        for (int i = from - 1; i < to; i++) {
            basket[i] = ballNumber;
        }
    }

    public String answer() {
        StringBuilder result = new StringBuilder();
        for (int j : basket) {
            result.append(j).append(" ");
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder();
        String firstLine = bf.readLine();
        input.append(firstLine).append("\n");
        int i = 0;
        while (i < Integer.parseInt(firstLine.split(" ")[1])) {
            input.append(bf.readLine()).append("\n");
            i++;
        }

        BJ10810 instance = new BJ10810(input.toString());
        System.out.print(instance.answer());
    }
}
