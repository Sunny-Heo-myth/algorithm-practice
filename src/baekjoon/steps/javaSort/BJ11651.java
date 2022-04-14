package baekjoon.steps.javaSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class BJ11651 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] pointArray = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = bf.readLine().split(" ");
            pointArray[i] = new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])};
        }

        int[] axis2ndCounting = new int[200001];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int axis2nd = pointArray[i][1];
            axis2ndCounting[axis2nd + 100000]++;

            if (!map.containsKey(axis2nd)) {
                map.put(axis2nd, new ArrayList<>());
                map.get(axis2nd).add(pointArray[i][0]);
            }
            else {
                map.get(axis2nd).add(pointArray[i][0]);
            }
        }

        map
            .forEach((key, value) -> {
            value.sort(Comparator.naturalOrder());
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 200001; i++) {
            for (int j = 0; j < axis2ndCounting[i]; j++) {
                sb.append(map.get(i - 100000).get(j)).append(" ").append(i - 100000).append("\n");
            }
        }
        System.out.print(sb);
    }
}
