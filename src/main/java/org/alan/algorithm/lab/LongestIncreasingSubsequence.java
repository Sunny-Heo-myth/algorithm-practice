package org.alan.algorithm.lab;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        lis.dp();
        lis.binarySearch();
    }
    public void dp() {
        int[] arr = {3, 2, 4, 1, 6};
        int[] dp = new int[arr.length];
        dp[0] = 1;

        for (int i = 1; i < arr.length; i++) for (int j = 0; j < i; j++) {
            if (arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            if (dp[i] == 0) dp[i] = 1;
        }

        System.out.println("arr : " + Arrays.toString(arr));
        System.out.println("DP  : " + Arrays.toString(dp));
    }

    public void binarySearch() {
        int[] arr = {3, 5, 7, 9, 2, 1, 4, 8, 13, 9, 6, 11, 14};
        int[] lis = new int[arr.length + 1];    // 가장 긴 증가하는 부분 수열. 가장 뒤에 있는 값은 부분 수열 중 가장 최댓값
        int lisIdx = 0;
        lis[lisIdx++] = arr[0]; // lis[lisIdx] 값을 arr[i]로 변경하고 1증가시킨다.

        for (int i = 1; i < arr.length; i++)    // lis값의 맨 마지막 원소가 arr[i] 보다 작을 경우
            if (lis[lisIdx - 1] < arr[i]) lis[lisIdx++] = arr[i]; // 해당 원소를 arr[i]값으로 변경하고 start를 1 증가 시킨다.
            else lis[lisIdx] = arr[i];    // lisIdx < end 일 경우 lis[lisIdx]의 값은 arr[i]의 값이 된다.

        System.out.println("arr : " + Arrays.toString(arr));
        System.out.println("LIS 길이 : " + lisIdx);
    }
}
