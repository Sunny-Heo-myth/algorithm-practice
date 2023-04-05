package org.alan.algorithm.practice.programmers.overtimeindex;

import java.util.Arrays;
import java.util.Comparator;

public class OvertimeIndex {
    private int energy;
    private Integer[] workArray;

    public long solution(int n, int[] works) {
        if (Arrays.stream(works).sum() < n) {
            return 0;
        }

        this.energy = n;
        this.workArray = Arrays.stream(works)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);

        work();

        return squareSum();
    }

    /**
     * <p>loop invariant: </a>
     * <p>initialization:</a>
     * <p>maintenance:</a>
     * <p>termination: </a>
     */
    private void work() {
        int from = 0;
        int length = 1;
        int to = from + length;
        while (energy > 0 && to < workArray.length) {
            int distance = workArray[from] - workArray[to];

//            if (to) {
//            }

            if (distance == 0) {
                length++;
            } else {
//                release();
                from = to;
                length = 1;
                to = from + length;
            }
        }
    }

    private long squareSum() {
        return Arrays.stream(workArray).mapToLong(i -> (long) i * i).sum();
    }


}
