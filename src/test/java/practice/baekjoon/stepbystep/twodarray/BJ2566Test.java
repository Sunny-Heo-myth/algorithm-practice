package practice.baekjoon.stepbystep.twodarray;

import org.junit.jupiter.api.Test;

public class BJ2566Test {

    private String input = "3 23 85 34 17 74 25 52 65\n" +
            "10 7 39 42 88 52 14 72 63\n" +
            "87 42 18 78 53 45 18 84 53\n" +
            "34 28 64 85 12 16 75 36 55\n" +
            "21 77 45 35 28 75 90 76 1\n" +
            "25 87 65 15 28 11 37 28 74\n" +
            "65 27 75 41 7 89 78 64 39\n" +
            "47 47 70 45 23 65 3 41 44\n" +
            "87 13 82 38 31 12 29 29 80";

    @Test
    void initializeTest() {
        BJ2566 instance = new BJ2566(input);
        System.out.printf("");
    }

    @Test
    void test1() {
        BJ2566 instance = new BJ2566(input);
        System.out.println(instance.answer());
    }
}
