package lab;

import java.util.Arrays;

public class ArrayCopy {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,0};
        int[] b = new int[5];
        System.arraycopy(a, 1, b, 1, 4);
        for (int i : b) {
            System.out.println(i);
        }

    }
}
