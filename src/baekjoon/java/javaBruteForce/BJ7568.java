package baekjoon.java.javaBruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[][] inputs = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] strings = bf.readLine().split(" ");
            inputs[i][0] = Integer.parseInt(strings[0]);
            inputs[i][1] = Integer.parseInt(strings[1]);
        }

        boolean[] persons = new boolean[n];
        persons[0] = true;
        GradeList gradeList = new GradeList(persons, inputs[0][0], inputs[0][1], inputs[0][0], inputs[0][1], 1);

        for (int i = 1; i < n; i++) {

        }
    }
}

class GradeList {
    boolean[] personList;
    int maxWeight;
    int minWeight;
    int maxHeight;
    int minHeight;
    int grade;

    public GradeList(boolean[] personList, int maxWeight, int minWeight, int maxHeight,
        int minHeight,
        int grade) {
        this.personList = personList;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
        this.maxHeight = maxHeight;
        this.minHeight = minHeight;
        this.grade = grade;
    }
}
