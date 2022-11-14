package practice.programmers.coloringBook;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers1829 {

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] dAxis1 = {1, 0, -1, 0};
        int[] dAxis2 = {0, 1, 0, -1};

        int[][] mirror = new int[m][n];
        for(int i=0; i<m; i++){
            System.arraycopy(picture[i], 0, mirror[i], 0, m);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int axis1 = point[0];
            int axis2 = point[1];
            int color = picture[axis1][axis2];
            for (int move = 0; move < 4; move++) {
                int nextAxis1 = axis1 + dAxis1[move];
                int nextAxis2 = axis2 + dAxis2[move];
                
                if (nextAxis1 >= m || nextAxis2 >= n || nextAxis1 < 0 || nextAxis2 < 0) {
                    continue;
                }

                int nextColor = picture[nextAxis1][nextAxis2];
                int status = mirror[nextAxis1][nextAxis2];
                if (nextColor == color) {
                    if (status > 0) {
                        queue.add(new int[]{nextAxis1, nextAxis2});
                        status = -status;
                    }
                } else {

                }
            }
        }




        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

}
