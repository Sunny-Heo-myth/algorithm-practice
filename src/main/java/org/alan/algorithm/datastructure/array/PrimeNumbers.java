package org.alan.algorithm.datastructure.array;

import java.util.HashSet;
import java.util.Set;

public class PrimeNumbers {
    public static void main(String[] args) {
        optimusPrime(1000);
    }

    static void prime1(int number) {
        int counter = 0;

        for (int n = 2; n <= number; n++) {
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

        for (int i = 3; i <= number; i += 2) {
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
        int operationCounter = 0;
        int primeCounter = 0;
        int[] primes = new int[number / 2];

        primes[primeCounter++] = 2;

        for (int candidate = 3; candidate <= number; candidate += 2) {  // o(n/2)
            int i;
            for (i = 1; i < primeCounter; i++) {
                operationCounter++;
                if (candidate % primes[i] == 0) {
                    break;
                }
            }
            if (primeCounter == i) {
                primes[primeCounter++] = candidate;
            }
        }

        for (int i = 0; i < primeCounter; i++) {
            System.out.println(primes[i]);
        }
        System.out.println("division count : " + operationCounter);
    }

    public static void prime4(int number) {
        int operationCounter = 0;
        int primeCounter = 0;
        int[] primes = new int[number / 2];

        primes[primeCounter++] = 2;
        primes[primeCounter++] = 3;

        for (int candidate = 5; candidate <= number; candidate += 2) {
            boolean flag = false;

            for (int i = 1; primes[i] * primes[i] <= candidate; i++) {
                operationCounter += 2;
                if (candidate % primes[i] == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                primes[primeCounter++] = candidate;
                operationCounter++;
            }
        }
        for (int i = 0; i < primeCounter; i++) {
            System.out.println(primes[i]);
        }
        System.out.println("multiplication and division count : " + operationCounter);
    }

    static void optimusPrime(int number) {
        int operationCount = 0;
        int primeCount = 0;
        int[] primes = new int[number/2];

        primes[primeCount++] = 2;
        primes[primeCount++] = 3;

        for (int candidate = 5; candidate <= number; candidate += 2) {
            boolean flag = false;
            for (int i = 1; primes[i] * primes[i] <= candidate; i++) {
                operationCount += 2;
                if (candidate % primes[i] == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                operationCount++;
                primes[primeCount++] = candidate;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < primeCount; index++) {
            sb.append(primes[index]).append("\n");
        }
        System.out.println(sb);
        System.out.println(operationCount);
    }
}
