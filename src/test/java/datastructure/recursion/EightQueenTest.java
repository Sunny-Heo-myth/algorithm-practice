package datastructure.recursion;

import concept.recursion.EightQueen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EightQueenTest {

    @Test
    void eightQueenTest() {
        boolean[] booleans = new boolean[8];
        EightQueen.eightQueen(8, booleans, 0);
        System.out.println(EightQueen.count);
    }

    @Test
    void setTest() {
        EightQueen.set(0);
    }

    @Test
    void set2Test() {
        EightQueen.set2(0);
    }

    @Test
    void set4Test() {
        EightQueen.set3(0);
    }
}
