package baekjoon.java.javaSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class BJ11650 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] pointArray = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = bf.readLine().split(" ");
            pointArray[i] = new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])};
        }

        int[] axis1stCounting = new int[200001];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int axis1st = pointArray[i][0];
            axis1stCounting[axis1st + 100000]++;

            if (!map.containsKey(axis1st)) {
                map.put(axis1st, new ArrayList<>());
                map.get(axis1st).add(pointArray[i][1]);
            }
            else {
                map.get(axis1st).add(pointArray[i][1]);
            }
        }

        map.forEach((key, value) -> {
            value.sort(Comparator.naturalOrder());
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 200001; i++) {
            for (int j = 0; j < axis1stCounting[i]; j++) {
                sb.append(i - 100000).append(" ").append(map.get(i - 100000).get(j)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
