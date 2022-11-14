package concept.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class InsertionSortTest {

    static int[] target;
    @BeforeEach
    public void before() {
        Random random = new Random();
        target = new int[100];
        for (int i = 0; i < 100; i++) {
            target[i] = random.nextInt();
        }
    }

    @Test
    public void insertionSort2Test() {
        new InsertionSort().secondInsertion(target);
        for (int i : target) {
            System.out.print(i + " ");
        }
    }

}
