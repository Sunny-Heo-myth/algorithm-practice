package baekjoon.javaBFSandDFS.BJ7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ7569 {

    static int[] dx = {1, 0, 0, -1, 0, 0};
    static int[] dy = {0, 1, 0, 0, -1, 0};
    static int[] dz = {0, 0, -1, 0, 0, 1};

    static int[][][] box;
    static int depth;
    static int height;
    static int width;

    static Queue<Banana> que;

    public static void main(String[] args) throws IOException {

        BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
        String[] size = bfReader.readLine().split(" ");
        width = Integer.parseInt(size[0]);
        height = Integer.parseInt(size[1]);
        depth = Integer.parseInt(size[2]);
        box = new int[depth][height][width]; // box[i][j][k] // box[z_coor][y_coor][x_coor]

        que = new LinkedList<Banana>();

        for(int i = 0; i < depth; i++) {
            for(int j = 0; j < height; j++) {
                String[] line = bfReader.readLine().split(" ");

                for(int k = 0; k < width; k++) {
                    box[i][j][k] = Integer.parseInt(line[k]);
                }
            }
        }
        bfReader.close();

        System.out.println(bfs());

    }

    static public int bfs(){
        // Already ripe.
        int unripe_count = 0;
        for(int i = 0; i < depth; i++) {
            for(int j = 0; j < height; j++) {
                for(int k = 0; k < width; k++) {

                    if(box[i][j][k] == 1) {
                        que.add(new Banana(k, j, i));
                    }
                    if(box[i][j][k] == 0) {
                        unripe_count += 1;
                    }
                }
            }
        }
        if(unripe_count == 0) {
            return 0;
        }
        // Riping process
        while(!que.isEmpty()) {
            Banana point = que.poll();

            for(int i = 0; i < 6; i++) {
                int target_x = point.getX() + dx[i];
                int target_y = point.getY() + dy[i];
                int target_z = point.getZ() + dz[i];

                if(target_x < 0 || target_y < 0 || target_z < 0 ||
                    target_x >= width || target_y >= height || target_z >= depth ||
                    box[target_z][target_y][target_x] != 0) {

                    continue; // get out of the rotation of the closest "for"
                }

                box[target_z][target_y][target_x] = box[point.getZ()][point.getY()][point.getX()] + 1;
                que.add(new Banana(target_x, target_y, target_z));
            }
        }

        //check
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < depth; i++) {
            for(int j = 0; j < height; j++) {
                for(int k = 0; k < width; k++) {
                    if(box[i][j][k] == 0) {
                        return -1;
                    }
                    if(max < box[i][j][k]) {
                        max = box[i][j][k];
                    }
                }
            }
        }
        return max - 1;
    }
}

class Banana {

    private int x;
    private int y;
    private int z;

    public Banana(int x, int y, int z) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getZ() {
        return z;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setZ(int z) {
        this.z = z;
    }


}
