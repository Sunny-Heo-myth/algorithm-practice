package practice.programmers.entranceCheck;

import java.io.IOException;
import java.util.Arrays;

public class Programmers_43238 {

    public static void main(String[] args) throws IOException {

        int[] guards = {7, 10};
        System.out.println(solution2(6, guards));

    }

    public static long solution1(int n, int[] times) {
        long elapsed = 0;
        long passed = 0;
        Arrays.sort(times);

        while (passed < n) {
            elapsed++;
            for (int guard : times) {
                if (elapsed < guard) {
                    break;
                }
                if (elapsed % guard == 0) {
                    passed++;
                }
            }
        }
        return elapsed;
    }

    public static long solution2(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long left = 0;
        long right = (long) n * times[times.length - 1];
        long mid;
        long sum;

        while (left <= right) {
            mid = (left + right) / 2;
            sum = 0;

            for (int guard : times) {
                sum += mid / guard;
            }

            if (sum < n) {
                left = mid + 1;
            }
            if (sum >= n) {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
