package practice.baekjoon.stepbystep.arraystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1546 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        double[] array = new double[n];
        double max = Float.MIN_VALUE;
        double sum = 0.0;
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Float.parseFloat(st.nextToken());
            if (array[i] >= max) max = array[i];
        }
        for (double f : array) {
            f = f / max * 100.0;
            sum += f;
        }
        System.out.println(sum / n);
    }
}
