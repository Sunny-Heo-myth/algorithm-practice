package practice.baekjoon.stepbystep.math1step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2775 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            int axis1st = Integer.parseInt(bf.readLine()) + 1;
            int axis2nd = Integer.parseInt(bf.readLine());
            int[][] array2dim = new int[axis1st][axis2nd];
            for (int j = 0; j < axis1st; j++) array2dim[j][0] = 1;
            for (int j = 0; j < axis2nd; j++) array2dim[0][j] = j + 1;
            for (int j = 1; j < axis1st; j++) for (int k = 1; k < axis2nd; k++)
                array2dim[j][k] = array2dim[j - 1][k] + array2dim[j][k - 1];
            sb.append(array2dim[axis1st - 1][axis2nd - 1]).append("\n");
        }
        System.out.print(sb);
    }
}
