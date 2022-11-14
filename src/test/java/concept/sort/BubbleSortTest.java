package concept.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class BubbleSortTest {
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
    public void bubbleSortTest() {
        BubbleSort.firstBubbleSort(target);
        for (int i : target) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void bookBubbleSortTest() {
        BubbleSort.secondBubbleSort(target);
        for (int i : target) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void backBubbleSortTest() {
        BubbleSort.thirdBubbleSort(target);
        for (int i : target) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void improvedBubbleSortTest() {
        BubbleSort.improvedBubbleSort(target);
        for (int i : target) {
            System.out.print(i + " ");
        }
    }

}
