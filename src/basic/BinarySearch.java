package basic;

public class BinarySearch {

    private static int binarySearch(int[] sortedArray, int target) {
        int start = 0;
        int end = sortedArray.length;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (sortedArray[mid] == target) {
                return mid;

            } else if (sortedArray[mid] > target) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
