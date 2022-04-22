package basic.Array;

import java.util.HashSet;
import java.util.Set;

public class PrimeNumbers {
    public static void main(String[] args) {
        prime4(1000);
    }

    static void prime(int number) {
        int counter = 0;

        for (int n = 2; n <= 1000; n++) {
            int i;
            for (i = 2; i < n; i++) {
                counter++;
                if (n % i == 0) {
                    break;
                }
            }
            if (n == i) {
                System.out.println(n);
            }
        }
        System.out.println("division count : " + counter);
    }

    static void prime2(int number) {
        Set<Integer> integers = new HashSet<>();
        int count = 0;
        integers.add(2);

        for (int i = 3; i <= 1000; i += 2) {
            int divisor = i;
            for (Integer prime : integers) {
                count++;

                if (i % prime == 0) {
                    divisor = prime;
                    break;
                }
            }
            if (divisor == i) {
                integers.add(i);
                System.out.println(i);
            }
        }
        System.out.println("division count : " + count);
    }

    static void prime3(int number) {
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;

        for (int n = 3; n <= 1000; n+= 2) {
            int i;
            for (i = 1; i < ptr; i++) {
                counter++;
                if (n % prime[i] == 0) {
                    break;
                }
            }
            if (ptr == i) {
                prime[ptr++] = n;
            }
        }

        for (int i = 0; i < ptr; i++) {
            System.out.println(prime[i]);
        }
        System.out.println("division count : " + counter);
    }

    public static void prime4(int number) {
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;
        prime[ptr++] = 3;

        for (int n = 5; n < 1000; n += 2) {
            boolean flag = false;

            for (int i = 1; prime[i] * prime[i] <= n; i++) {
                counter += 2;
                if (n % prime[i] == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                prime[ptr++] = n;
                counter++;
            }
        }

        for (int i = 0; i < ptr; i++) {
            System.out.println(prime[i]);
        }
        System.out.println("division count : " + counter);
    }
}
