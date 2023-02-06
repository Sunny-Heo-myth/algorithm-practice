package practice.baekjoon.stepbystep.setandmapstep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BJ14425Test {

    @Test
    public void test1() {
        String inputString = "5 11\n" +
                "baekjoononlinejudge\n" +
                "startlink\n" +
                "codeplus\n" +
                "sundaycoding\n" +
                "codingsh\n" +
                "baekjoon\n" +
                "codeplus\n" +
                "codeminus\n" +
                "startlink\n" +
                "starlink\n" +
                "sundaycoding\n" +
                "codingsh\n" +
                "codinghs\n" +
                "sondaycoding\n" +
                "startrink\n" +
                "icerink";

        int expected = 4;

        BJ14425 instance = new BJ14425(inputString);
        int answer = instance.answer();
        System.out.println(answer);
        Assertions.assertEquals(expected, answer);
    }
}
