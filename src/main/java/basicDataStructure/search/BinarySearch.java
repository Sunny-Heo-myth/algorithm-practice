package basicDataStructure.search;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binSearchX(new int[]{1,2,3,4,5,5,5,7,34,78,888}, 11, 5));

        System.out.println("---- binary reserved search ----\n");
        System.out.println(Arrays.binarySearch(reserved, "static"));
    }

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

    private static int binarySearch(int[] sortedArray, int n, int key) {
        int start = 0;
        int end;
        int middle;
        return 0;
    }

    private static int binSearch(int[] sortedArray, int n, int key) {
        int startIndex = 0;
        int endIndex = n - 1;

        do {
            int middleIndex = (startIndex + endIndex) / 2;
            if (sortedArray[middleIndex] == key) {
                return middleIndex;
            }
            else if (sortedArray[middleIndex] < key) {
                startIndex = middleIndex + 1;
            }
            else {
                endIndex = middleIndex - 1;
            }
        } while (startIndex <= endIndex);

        return -1;
    }

    private static int binSearchX(int[] sortedArray, int n, int key) {
        int startIndex = 0;
        int endIndex = n - 1;
        int resultIndex = n;

        do {
            int middleIndex = (startIndex + endIndex) >>> 1;
            int value = sortedArray[middleIndex];

            if (value == key) {
                resultIndex = value;
                break;
            }
            else if (value < key) {
                startIndex = ++middleIndex;
            }
            else {
                endIndex = --middleIndex;
            }
        } while (startIndex <= endIndex);

        int answerIndex = --resultIndex;
        while (sortedArray[answerIndex] == key) {
            answerIndex--;
        }

        return ++answerIndex;
    }

    static String[] reserved = {
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import", "instanceOf", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
            "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"
    };
}
