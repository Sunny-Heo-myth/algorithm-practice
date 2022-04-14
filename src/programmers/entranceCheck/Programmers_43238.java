package programmers.entranceCheck;

import java.io.IOException;
import java.util.Arrays;

public class Programmers_43238 {

    public static void main(String[] args) throws IOException {

        int[] guards = {2, 3, 5, 10 ,20};
        System.out.println(solution1(50, guards));

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

        long start = 0L;
        Arrays.sort(times);
        long end = (long) n * times[times.length - 1];


        while (start <= end) {
            int sum = 0;
            long mid = (start + end) / 2;
            for (int guard : times) {
                sum += mid % guard;
            }

            if (sum > n) {
                end = mid - 1;
            } else if (sum < n) {
                start = mid + 1;
            }
        }

        return 0L;
    }
}
