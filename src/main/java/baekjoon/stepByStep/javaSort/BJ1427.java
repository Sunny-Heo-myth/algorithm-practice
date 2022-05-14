package baekjoon.stepByStep.javaSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] numbers = bf.readLine().toCharArray();

        int[] sortedArray = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            sortedArray[Character.getNumericValue(numbers[i])]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = sortedArray.length - 1; i >= 0 ; i--) {
            if (sortedArray[i] != 0) {
                for (int j = 0; j < sortedArray[i]; j++) {
                    sb.append(i);
                }
            }
        }
        System.out.print(sb);
    }
}
