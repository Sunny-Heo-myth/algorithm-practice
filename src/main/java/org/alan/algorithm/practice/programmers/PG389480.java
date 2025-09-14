package org.alan.algorithm.practice.programmers;

import java.util.Arrays;

public class PG389480 {

    public int solution(int[][] info, int n, int m) {
        int INVALID = 1_000_000_000;
        // LOOP INVARIANT => minimum sum of trace A when the sum of trace B is exactly m
        // initiation:
        // - no item has been considered => memo[0] = 0
        // - When the sum of B trace is 0,the minimum sum of A trace is 0.
        // - When memo[i] with i > 0, since no item has been considered, memo[i] is invalid
        // maintenance:
        // - memo[i] is the minimum sum of trace A until the trace is considered for every i
        // termination:
        // - All items are considered and the memo[i] is the minimum sum of A trace
        // while the sum of B trace is exactly i
        int[] memo = new int[m];
        Arrays.fill(memo, INVALID);
        memo[0] = 0;
        for (int[] item : info) {
            int aTrace = item[0], bTrace = item[1];
            int[] temp = new int[m];
            Arrays.fill(temp, INVALID);
            for (int bSum = 0; bSum < m; bSum++) {
                if (memo[bSum] == INVALID) continue;
                if (memo[bSum] + aTrace < n) temp[bSum] = Math.min(temp[bSum], memo[bSum] + aTrace);
                if (bSum + bTrace < m) temp[bSum + bTrace] = Math.min(temp[bSum + bTrace], memo[bSum]);
            }
            memo = temp;
        }
        return Arrays.stream(memo).filter(aSum -> aSum != INVALID).min().orElse(-1);
    }
}
