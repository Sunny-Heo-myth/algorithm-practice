package basic.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
        BubbleSort.bubbleSort(target);
        for (int i : target) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void bookBubbleSortTest() {
        BubbleSort.bookBubbleSort(target);
        for (int i : target) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void backBubbleSortTest() {
        BubbleSort.backBubbleSort(target);
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
