package org.alan.algorithm.practice.programmers.overtimeindex;

import java.util.Arrays;
import java.util.Comparator;

public class OvertimeIndex2 {
    private int energy;
    private Integer[] workArray;

    public long solution(int n, int[] works) {
        if (Arrays.stream(works).sum() <= n) {
            return 0;
        }

        this.energy = n;
        workArray = Arrays.stream(works).boxed().toArray(Integer[]::new);   // n
        Arrays.sort(workArray, Comparator.reverseOrder());  // n log n

        work();
        return squareSum();
    }

    private void work() {
        int currentIndex = 0;
        while (energy > 0) {
            int nextIndex = currentIndex + 1;

            if (currentIndex == workArray.length - 1) {
                release(workArray[currentIndex], nextIndex);

            } else {
                int distance = workArray[currentIndex] - workArray[nextIndex];
                if (distance != 0) {
                    release(distance, nextIndex);
                }
            }

            currentIndex++;
        }
    }

    private void release(int distance, int index) {
        for (int j = 0; j < distance * index; j++) {
            workArray[j % index]--;
            energy--;

            if (energy == 0) {
                break;
            }
        }
    }

    private long squareSum() {
        return Arrays.stream(workArray).mapToLong(i -> (long) i * i).sum(); // n
    }
}
