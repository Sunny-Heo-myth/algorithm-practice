package org.alan.algorithm.practice.baekjoon.stepbystep.setandmapstep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BJ1620Test {
    @Test
    public void test1() {
        String inputString = "26 5\n" +
                "Bulbasaur\n" +
                "Ivysaur\n" +
                "Venusaur\n" +
                "Charmander\n" +
                "Charmeleon\n" +
                "Charizard\n" +
                "Squirtle\n" +
                "Wartortle\n" +
                "Blastoise\n" +
                "Caterpie\n" +
                "Metapod\n" +
                "Butterfree\n" +
                "Weedle\n" +
                "Kakuna\n" +
                "Beedrill\n" +
                "Pidgey\n" +
                "Pidgeotto\n" +
                "Pidgeot\n" +
                "Rattata\n" +
                "Raticate\n" +
                "Spearow\n" +
                "Fearow\n" +
                "Ekans\n" +
                "Arbok\n" +
                "Pikachu\n" +
                "Raichu\n" +
                "25\n" +
                "Raichu\n" +
                "3\n" +
                "Pidgey\n" +
                "Kakuna";

        String expected = "Pikachu\n" +
                "26\n" +
                "Venusaur\n" +
                "16\n" +
                "14";

        BJ1620 instance = new BJ1620(inputString);
        String answer = instance.answer();
        System.out.println(answer);
        Assertions.assertEquals(expected, answer);
    }
}
