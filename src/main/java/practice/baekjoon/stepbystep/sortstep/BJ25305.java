package practice.baekjoon.stepbystep.sortstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ25305 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        sb.append(bf.readLine()).append("\n").append(bf.readLine());
        System.out.print(new BJ25305().solve(sb.toString()));
    }

    public int solve(String input) {
        String[] inputStrings = input.split("\n");
        String[] secondLine = inputStrings[1].split(" ");
        int rank = Integer.parseInt(inputStrings[0].split(" ")[1]);
        int[] numbers = Arrays.stream(secondLine).mapToInt(Integer::parseInt).toArray();

        insertionSort(numbers);
        return numbers[rank - 1];
    }

    private void insertionSort(int[] numbers) {
        int length = numbers.length;
        for (int left = 0; left < length; left++) {
            for (int right = left + 1; right < length; right++) {
                if (numbers[left] < numbers[right]) {
                    swap(numbers, left, right);
                }
            }
        }
    }

    private void swap(int[] array, int alpha, int beta) {
        int temp = array[alpha];
        array[alpha] = array[beta];
        array[beta] = temp;
    }
}
