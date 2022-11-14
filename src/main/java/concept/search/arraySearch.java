package concept.search;

public class arraySearch {
    public static void main(String[] args) {

        int[] ints = {1,2,3,4,5,6,7,8,9};
        System.out.println(seqSearch(ints, 8, 8));
    }

    private static <T> int sequentialSearch(T[] array, T sth) {
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i] == sth) {
                return i;
            }
        }
        return -1;
    }

    private static int seqSearch(int[] a, int n, int key) {
        int i = 0;

        while (true) {
            if (i == n) {
                return -1;
            }
            if (a[i] == key) {
                return i;
            }
            i++;
        }
    }

    private static int seqSearch2(int[] a, int n, int key) {
        for (int i = 0; i < n; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private static int seqSearchSentry(int[] a, int n, int key) {
        a[n] = key; // n + 1 th value
        int i = 0;
        while (true) {
            if (a[i] == key) {
                break;
            }
        }
        return i == n ? -1 : i;
    }
}
