package org.alan.algorithm.lab;

import org.junit.jupiter.api.Test;

public class SystemTest {

    @Test
    void arraycopyTest() {
        // given
        int[] source1 = {1,2,3,4,5,6,7,8,9,0};
        int[] destination1 = {11,12,13,14,15,16,17,18,19,20};

        // when
        System.arraycopy(source1, 4, destination1, 4, 5);

        // then
        for (int i : destination1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Test
    void arraycopy2Test() {
        // given
        int[] source2 = {1,2,3,4,5,6,7,8,9,0};
        int[] destination2 = {11,12,13,14,15,16,17,18,19,20};

        // when
        System.arraycopy(source2, 4, destination2, 4, 6);

        // then
        for (int i : destination2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Test
    void arraycopy3Test() {
        // given
        int[] source3 = {1,2,3,4,5,6,7,8,9,0};
        int[] destination3 = {11,12,13,14,15,16,17,18,19,20};

        // when
        System.arraycopy(source3, 0, destination3, 0, 5);

        // then
        for (int i : destination3) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Test
    void arraycopy4Test() {
        // given
        int[] source3 = {1,2,3,4,5,6,7,8,9,0};
        int[] destination3 = {11,12,13,14,15,16,17,18,19,20};

        // when
        System.arraycopy(source3, 0, destination3, 0, 10);

        // then
        for (int i : destination3) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Test
    void arraycopy5Test() {
        // given
        int[] source = {1,2,3,4,5,6,7,8,9,0};
        int[] destination = {11,12,13,14,15,16,17,18,19,20};

        // when
        System.arraycopy(source, 1, destination, 3, 6);

        // then
        for (int i : destination) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
