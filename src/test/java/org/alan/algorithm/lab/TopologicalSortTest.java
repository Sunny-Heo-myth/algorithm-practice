package org.alan.algorithm.lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TopologicalSortTest {

    @Test
    void test1() {
        int numberOfNodes = 7;
        int[] from = {1, 1, 2, 4, 3, 3, 5, 2, 5};
        int[] to = {2, 3, 5, 6, 4, 7, 6, 4, 4};
        TopologicalSort topo = new TopologicalSort(7, from, to);
        var answer = topo.solve();
        System.out.println(answer);
        Assertions.assertEquals("[1, 2, 3, 5, 7, 4, 6]", topo.solve().toString());
    }

    @Test
    void test2() {
        int[] nodes = {1,2,3,4,5,6,7};
        int[] from = {1, 1, 2, 4, 3, 3, 5, 2, 5};
        int[] to = {2, 3, 5, 6, 4, 7, 6, 4, 4};
        TopologicalSort topo = new TopologicalSort(nodes, from, to);
        var answer = topo.solve();
        System.out.println(answer);
        Assertions.assertEquals("[1, 2, 3, 5, 7, 4, 6]", topo.solve().toString());
    }
}