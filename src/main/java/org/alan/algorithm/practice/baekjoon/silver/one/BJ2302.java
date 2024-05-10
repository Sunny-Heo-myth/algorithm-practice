package org.alan.algorithm.practice.baekjoon.silver.one;

public class BJ2302 {
    private boolean[] tickets;
    private boolean[] vip;
    private int cases = 0;
    public String solve(String input) {
        tickets = new boolean[Integer.parseInt(input.split("\n")[0]) + 1]; tickets[0] = true;
        vip = new boolean[tickets.length]; vip[0] = true;
        input.lines().skip(2).mapToInt(Integer::parseInt).forEach(i -> { vip[i] = true; tickets[i] = true; });

        recur(1);
        return String.valueOf(cases);
    }

    private void recur(int seat) {
        if (seat == tickets.length) { cases++; return; }
        if (vip[seat]) { recur(seat + 1); return; }
        int a = seat - 1;
        if (a >= 0 && !tickets[a]) recur(seat, a);
        if (!tickets[seat]) recur(seat, seat);
        int b = seat + 1;
        if (b < tickets.length && !tickets[b]) recur(seat, b);
    }

    private void recur(int seat, int ticket) {
        tickets[ticket] = true;
        recur(seat + 1);
        tickets[ticket] = false;
    }
}
