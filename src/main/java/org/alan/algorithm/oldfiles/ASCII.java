package org.alan.algorithm.oldfiles;

public class ASCII {

    public static void main(String[] args) {
        alphanumeric2();
    }

    static void alphanumeric() {
        char a = 'a';
        char z = 'z';
        char A = 'A';
        char Z = 'Z';
        System.out.println(Character.getNumericValue(a) +
            "\n" + Character.getNumericValue(A) +
            "\n" + Character.getNumericValue(z) +
            "\n" + Character.getNumericValue(Z));
        System.out.print((char) 65);
    }

    static void alphanumeric2() {
        char[] chars = "1234".toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }
}
