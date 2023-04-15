package org.alan.algorithm.practice.programmers.waytoschool;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WayToSchoolTest {

    @Test
    public void test1() {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};
        int expected = 4;
        WayToSchool instance = new WayToSchool();
        Assertions.assertEquals(expected, instance.solution(m,n,puddles));
    }


}
