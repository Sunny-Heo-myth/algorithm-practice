package practice.baekjoon.stepbystep.twodimensionalarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2738_2 {
    private int row;
    private int column;
    private int[][] inputArray1;
    private int[][] inputArray2;
    private int[][] answerArray;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(bf.readLine()).append("\n");
        int n = Integer.parseInt(s.toString().split(" ")[0]) * 2;
        int i = 0;
        while (i < n) {
            s.append(bf.readLine()).append("\n");
            i++;
        }
        BJ2738_2 instance = new BJ2738_2(s.deleteCharAt(s.length() - 1).toString());
        System.out.print(instance.answer());
    }

    public BJ2738_2(String input) {
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        row = Integer.parseInt(firstLine[0]);
        column = Integer.parseInt(firstLine[1]);
        inputArray1 = new int[row][column];
        inputArray2 = new int[row][column];

        for (int i = 1; i < row + 1; i++) {
            String[] line = lines[i].split(" ");
            for (int j = 0; j < column; j++) {
                inputArray1[i - 1][j] = Integer.parseInt(line[j]);
            }
        }
        for (int i = row + 1; i < 2*row + 1; i++) {
            String[] line = lines[i].split(" ");
            for (int j = 0; j < column; j++) {
                inputArray2[i - (row + 1)][j] = Integer.parseInt(line[j]);
            }
        }
    }

    public String answer() {
        answerArray = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                answerArray[i][j] = inputArray1[i][j] + inputArray2[i][j];
            }
        }
        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                answer.append(answerArray[i][j]).append(" ");
            }
            answer.deleteCharAt(answer.length() - 1).append("\n");
        }
        return answer.deleteCharAt(answer.length() - 1).toString();
    }
}
