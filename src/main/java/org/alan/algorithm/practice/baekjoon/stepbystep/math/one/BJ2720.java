package org.alan.algorithm.practice.baekjoon.stepbystep.math.one;

public class BJ2720 {
    public String solve(String input) {
        int remain = Integer.parseInt(input);
        int quarter = 0;
        int dime = 0;
        int nickel = 0;
        int penny = 0;
        while (remain > 0) {
            if (remain >= Coin.Quarter.unit) {
                remain -= Coin.Quarter.unit;
                quarter++;
            } else if (remain >= Coin.Dime.unit) {
                remain -= Coin.Dime.unit;
                dime++;
            } else if (remain >= Coin.Nickel.unit) {
                remain -= Coin.Nickel.unit;
                nickel++;
            } else {
                remain -= Coin.Penny.unit;
                penny++;
            }
        }
        return quarter + " " + dime + " " + nickel + " " + penny;
    }

    enum Coin {
        Quarter(25), Dime(10), Nickel(5), Penny(1);

        private final int unit;

        Coin(int unit) {
            this.unit = unit;
        }
    }

}
