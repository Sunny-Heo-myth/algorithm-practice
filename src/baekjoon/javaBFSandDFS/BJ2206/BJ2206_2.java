package baekjoon.javaBFSandDFS.BJ2206;

import java.util.ArrayList;

public class BJ2206_2 {

    public static void main(String[] args) {

        ArrayList<int[]> al1 = new ArrayList<>();
        al1.add(new int[]{1, 0});
        al1.add(new int[]{1, 1});
        al1.add(new int[]{1, 2});
        ArrayList<int[]> al2 = new ArrayList<>();
        al2.add(new int[]{2, 0});
        al2.add(new int[]{2, 1});
        al2.add(new int[]{2, 2});

        Input input1 = new Input(new int[][]{{0, 0}, {0, 0}}, al1, 5);
        Input input2 = new Input(new int[][]{{0, 0}, {0, 0}}, al1, 5);

        System.out.println(input1 == input2);
    }
}
