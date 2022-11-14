package practice.baekjoon;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class BJ14502Test {

    @Test
    void test_1() {
        String input = "7 7\n" +
                "2 0 0 0 1 1 0\n" +
                "0 0 1 0 1 2 0\n" +
                "0 1 1 0 1 0 0\n" +
                "0 1 0 0 0 0 0\n" +
                "0 0 0 0 0 1 1\n" +
                "0 1 0 0 0 0 0\n" +
                "0 1 0 0 0 0 0";

        BJ14502 instance = new BJ14502(input);
        System.out.print(instance.row * instance.column - (instance.invasion(instance.viruses, instance.map, instance.select3Dots(instance.map)) + instance.wall + 3));
    }

    @Test
    void test_2() {
        String input = "4 6\n" +
                "0 0 0 0 0 0\n" +
                "1 0 0 0 0 2\n" +
                "1 1 1 0 0 2\n" +
                "0 0 0 0 0 2";

        BJ14502 instance = new BJ14502(input);
        System.out.print(instance.row * instance.column - (instance.invasion(instance.viruses, instance.map, instance.select3Dots(instance.map)) + instance.wall + 3));
    }

    @Test
    void test_3() {
        String input = "8 8\n" +
                "2 0 0 0 0 0 0 2\n" +
                "2 0 0 0 0 0 0 2\n" +
                "2 0 0 0 0 0 0 2\n" +
                "2 0 0 0 0 0 0 2\n" +
                "2 0 0 0 0 0 0 2\n" +
                "0 0 0 0 0 0 0 0\n" +
                "0 0 0 0 0 0 0 0\n" +
                "0 0 0 0 0 0 0 0";

        BJ14502 instance = new BJ14502(input);
        System.out.print(instance.row * instance.column - (instance.invasion(instance.viruses, instance.map, instance.select3Dots(instance.map)) + instance.wall + 3));
    }

}
