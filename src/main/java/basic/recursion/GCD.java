package basic.recursion;

public class GCD {

    static int euclidGcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        else {
            return euclidGcd(y, x % y);
        }
    }

    static int euclidGcd(int[] ints) {
        int gcd = ints[0];
        for (int i = 1; i < ints.length; i++) {
            gcd = euclidGcd(gcd, ints[i]);
        }
        return gcd;
    }

    static int gcd(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}
