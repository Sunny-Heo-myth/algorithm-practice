package practice.baekjoon.stepbystep.dynamicProgrammingStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2579 {
    static int num;
    static int[] stairsArr;
    static Integer[] maxStairsArr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(bf.readLine());
        stairsArr = new int[num + 1];
        maxStairsArr = new Integer[num + 1];
        for (int i = 1; i <= num; i++) {
            stairsArr[i] = Integer.parseInt(bf.readLine());
        }

        maxStairsArr[0] = stairsArr[0];
        maxStairsArr[1] = stairsArr[1];
        if(num >= 2) {
            maxStairsArr[2] = stairsArr[1] + stairsArr[2];
        }
        System.out.print(jump(num));
    }

    static int jump(int step) {
        if (maxStairsArr[step] == null) {
             maxStairsArr[step] = stairsArr[step] +
                     Math.max(jump(step - 2), stairsArr[step - 1] + jump(step - 3));
        }
        return maxStairsArr[step];
    }
}
