package org.alan.algorithm.datastructure.array;

import java.util.Arrays;
import java.util.Stack;

// Array is a unique data structure where you have to specify a size when you initialize it.
public class Array {
    public static void main(String[] args) {
        int[] a = new int[5];   // O(n)
        a[1] = 37;
        a[2] = 51;
        a[4] = a[1] * 2;

        for (int i = 0; i < a.length; i++) {    // O(n)
            System.out.println("a[" + i + "] = " + a[i]);
        }

        System.out.println("\nArray Initializer\n");

        int[] ab = {1,2,3,4,5};

        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + ab[i]);
        }

        System.out.println("\nclone array\n");

        int[] abc = {1,2,3,4,5};
        int[] abc2 = abc.clone();   // O(n)
        System.out.println(Arrays.hashCode(abc) == Arrays.hashCode(abc2));  // not a good idea
        System.out.println(abc.hashCode() == abc2.hashCode());  // This proves address of each reference is different.

        System.out.println("\nmax\n");

        int max = abc[0];
        for (int i = 1; i < abc.length; i++) {  // O(n)
            if (abc[i] > max) {
                max = abc[i];
            }
        }
        System.out.println(max);

        System.out.println("\nreverse\n");
        int[] abcd = {1,2,3,4,5,6,7};
        int[] abcd2 = {1,2,3,4,5,6,7,8};

        for (int i = 0; i < (abcd.length / 2); i++) {   // O(n/2)
            elementReverseSwap(abcd, i);
        }

        for (int i = 0; i < (abcd2.length / 2); i++) {   // O(n/2)
            elementReverseSwap(abcd2, i);
        }

        System.out.println("abcd");
        for (int i : abcd) {
            System.out.println(i);
        }

        System.out.println("abcd2");
        for (int i : abcd2) {
            System.out.println(i);
        }

        System.out.println("\nequal test\n");

        int[] ints1 = {1,2,3,4,5};
        int[] ints2 = {1,2,3,4,6};
        System.out.println(arrayElementEquals(ints1, ints2));

        System.out.println("\ncopy test\n");
        copy(ints1, ints2);
        Arrays.stream(ints2).forEach(System.out::println);  // O(n)

        System.out.println("\nchangeNumeric test\n");
        System.out.println(changeNumeric(16, 59));
        char[] chars = new char[100];
        cardConvR(1260, 36, chars);
        StringBuilder sb = new StringBuilder(String.valueOf(chars)).reverse();
        System.out.println(sb);
    }

    static void elementReverseSwap(int[] ints, int index) {
        int temp = ints[index]; // O(1)
        ints[index] = ints[ints.length - 1 - index];    // O(1)
        ints[ints.length - 1 - index] = temp;   // O(1)
    }

    static boolean arrayElementEquals(int[] array1, int[] array2) {

        if (array1.length != array2.length) {   // O(1)
            return false;
        }

        for (int i = 0; i < array1.length; i++) {   //O(n)
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }

    static void copy(int[] a, int[] b) {
        if (a.length < b.length) {
            for (int i = 0; i < a.length; i++) {
                a[i] = b[i];
            }
        }
        else {
            for (int i = 0; i < b.length; i++) {
                a[i] = b[i];
            }
        }
    }

    // A maximum value of target is 16
    static String changeNumeric(int target, int number) {
        String[] symbols = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        Stack<String> strings = new Stack<>();
        int remainder = 0;

        while (target < number) {   // o(number/target)
            remainder = number % target;
            strings.push(symbols[remainder]);
            number /= target;
        }
        strings.push(symbols[number]);  //o(length)

        StringBuilder result = new StringBuilder();
        while (!strings.isEmpty()) {
            result.append(strings.pop());   // o(length)
        }

        return result.toString();
    }

    static int cardConvR(int x, int r, char[] d) {
        int digits = 0;
        String digitChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = digitChar.charAt(x % r);
            x /= r;
        } while (x != 0);

        return digits;
    }




}
