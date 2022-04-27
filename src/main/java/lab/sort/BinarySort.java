package lab.sort;

import java.util.Arrays;

public class BinarySort {

    public static void main(String[] args) {
        int[] arr = {1,5,8,3,7,2};
        Arrays.sort(arr);

        System.out.println(binarySort(arr , 8));
    }

    private static int binarySort(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        do {
            int middle = (left + right)/2;
            int compare = arr[middle];
            if (compare == target) {
                return middle;
            } else if (compare > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        } while (left <= right);
        return -1;
    }


}
