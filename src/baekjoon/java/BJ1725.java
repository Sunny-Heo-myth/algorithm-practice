package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1725 {
    static int n;
    static int[] histogram;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        histogram = new int[n];
        max = n;

        for (int i = 0; i < histogram.length; i++) {
            histogram[i] = Integer.parseInt(bf.readLine());
        }

        maxRectangle();
        System.out.print(max);
    }

    static void maxRectangle() {

        for (int i = 0; i < n; i++) {

            int height = histogram[i];

            int j = i;
            int width = 0;

            while (height > 1 && j < n) {

                if (histogram[j] >= height) {
                    j++;
                    width++;
                    max = Math.max(max, height*width);
                }
                else {
                    max = Math.max(max, height*width);
                    height = histogram[j];
                    j = width + 1;
                }

            }
        }

    }
}
