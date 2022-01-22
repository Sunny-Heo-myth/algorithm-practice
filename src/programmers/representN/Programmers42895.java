package programmers.representN;

import java.util.HashSet;
import java.util.Set;

public class Programmers42895 {

    public static void main(String[] args) {

    }

    public int solution(int N, int number) {
        // count how much N has been used
        int count = 0;
        // do until number comes out from count one;
        while (count <= 8) {
            int result = 0;

            if (result == number) {
                break;
            }
            // if number doesn't comes out increase count until count
            count++;
        }

        if (count == 9) {
            return -1;
        }
        else {
            return count;
        }
    }

    // result set of operations between the result of operations
    public static Set<Integer> operations(int n, Set<Integer> input1, Set<Integer> input2) {
        Set<Integer> result = new HashSet<>();


        return result;
    }

    public int concatenate(int number) {
        return Integer.parseInt(Integer.toString(number) + Integer.toString(number));
    }
}
