package practice.baekjoon.stepbystep.dfsAndBfsStep.BJ7574;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main2 {

    static int n;
    static int size;
    static int step;
    static List<Petal> petals = new ArrayList<>();
    static Stack<Petal> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = bfReader.readLine().split(" ");

        n = Integer.parseInt(input1[0]);
        size = Integer.parseInt(input1[1]);

        for (int i = 0; i < n; i++) {
            String[] input2 = bfReader.readLine().split(" ");
            Petal petal = new Petal(new int[]{Integer.parseInt(input2[0]), Integer.parseInt(input2[1])});
            petals.add(petal);
        }

        String input3 = bfReader.readLine();
        step = Integer.parseInt(input3);
        bfReader.close();

        System.out.println(dfs());
    }

    private static int dfs() {

        int distance = Integer.MIN_VALUE;
        Petal startingPoint = petals.get(0);
        stack.push(startingPoint);

        while (!stack.isEmpty()) {
            Petal targetPetal = stack.pop();
            for (Petal p : petals) {

                int diff_x = p.getCoordi()[0] - targetPetal.getCoordi()[0];
                int diff_y = p.getCoordi()[1] - targetPetal.getCoordi()[1];

                if ((diff_x >= 0 && diff_y >= 0 && size + step >= diff_x && size >= diff_y)
                        || (diff_x >= 0 && diff_y >= 0 && size >= diff_x && size + step >= diff_y)
                        || (diff_x < 0 && diff_y >= 0 && size + step >= -diff_x && size >= diff_y)
                        || (diff_x >= 0 && diff_y < 0 && size >= diff_x && size + step >= -diff_y)){

                    if(!p.isVisited()) {
                        stack.add(p);
                        p.setVisited(true);

                        if (p.getCoordi()[0] + p.getCoordi()[1] + size * 2 > distance) {
                            distance = p.getCoordi()[0] + p.getCoordi()[1] + size * 2;
                        }
                    }
                }
            }
        }

        return distance;
    }

}

