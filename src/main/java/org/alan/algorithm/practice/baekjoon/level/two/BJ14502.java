package org.alan.algorithm.practice.baekjoon.level.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BJ14502 {
    public int[][] getMap() {
        return map;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getWall() {
        return wall;
    }

    public List<int[]> getViruses() {
        return viruses;
    }

    private final int[][] map;
    private int row = 0;
    private int column = 0;
    private int wall = 0;
    private final List<int[]> viruses;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        String s = bf.readLine();
        stringBuilder.append(s).append("\n");
        String[] strings = s.split(" ");
        for (int i = 0; i < Integer.parseInt(strings[0]); i++) {
            stringBuilder.append(bf.readLine()).append("\n");
        }
        BJ14502 instance = new BJ14502(stringBuilder.toString());
        System.out.print(instance.row * instance.column - (instance.invasion(instance.viruses, instance.map, instance.select3Dots(instance.map)) + instance.wall + 3));
    }

    public BJ14502(String input) {
        String[] strings = input.split("\n");
        String[] firstLine = strings[0].split(" ");
        row = Integer.parseInt(firstLine[0]);
        column = Integer.parseInt(firstLine[1]);
        map = new int[row][column];
        viruses = new ArrayList<>();

        for (int i = 1; i < strings.length; i++) {
            String[] e = strings[i].split(" ");
            for (int j = 0; j < column; j++) {
                int sth = Integer.parseInt(e[j]);
                if (sth == 1) {
                    wall++;
                }
                else if (sth == 2) {
                    viruses.add(new int[]{i - 1, j});
                }
                map[i - 1][j] = sth;
            }
        }

        List<int[][]> list = select3Dots(map);
    }

    public List<int[][]> select3Dots(int[][] map) {
        List<int[][]> optionList = new ArrayList<>();
        int totalCount = row * column;

        for (int first = 0; first < totalCount; first++) {
            int first_x = first / column;
            int first_y = first % column;
            if (map[first_x][first_y] == 0) {
                map[first_x][first_y] = 1;
                int[] firstWall = new int[]{first_x, first_y};

                for (int second = first + 1; second < totalCount; second++) {
                    int second_x = second / column;
                    int second_y = second % column;
                    if (map[second_x][second_y] == 0) {
                        map[second_x][second_y] = 1;
                        int[] secondWall = new int[]{second_x, second_y};

                        for (int third = second + 1; third < totalCount; third++) {
                            int third_x = third / column;
                            int third_y = third % column;
                            if (map[third_x][third_y] == 0) {
                                map[third_x][third_y] = 1;
                                int[] thirdWall = new int[]{third_x, third_y};
                                optionList.add(new int[][]{firstWall, secondWall, thirdWall});

                                map[third_x][third_y] = 0;
                            }
                        }
                        map[second_x][second_y] = 0;
                    }
                }
                map[first_x][first_y] = 0;
            }
        }
        return optionList;
    }

    public int invasion(List<int[]> viruses, int[][] map, List<int[][]> wallOptions) {
        int answer = Integer.MAX_VALUE;

        for (int[][] option : wallOptions) {
            for (int i = 0; i < 3; i++) {
                map[option[i][0]][option[i][1]] = 1;
            }

            Stack<int[]> stack = new Stack<>();
            stack.addAll(viruses);

            int[][] duplicatedMap = new int[row][column];
            for (int i = 0; i < row; i++) {
                System.arraycopy(map[i], 0, duplicatedMap[i], 0, column);
            }

            int infected = infectStack(stack, duplicatedMap);

            if (infected < answer) {
                answer = infected;
            }

            for (int i = 0; i < 3; i++) {
                map[option[i][0]][option[i][1]] = 0;
            }
        }

        return answer;
    }

    private int infectStack(Stack<int[]> stack, int[][] map) {
        int size = stack.size();

        int[] virus;
        while (!stack.isEmpty()) {
            virus = stack.pop();
            int x = virus[0];
            int y = virus[1];

            int up = x - 1;
            int down = x + 1;
            int left = y - 1;
            int right = y + 1;

            if (up >= 0 && map[up][y] == 0) {
                map[up][y] = 2;
                stack.push(new int[]{up, y});
                size++;
            }
            if (down < row && map[down][y] == 0) {
                map[down][y] = 2;
                stack.push(new int[]{down, y});
                size++;
            }
            if (left >= 0 && map[x][left] == 0) {
                map[x][left] = 2;
                stack.push(new int[]{x, left});
                size++;
            }
            if (right < column && map[x][right] == 0) {
                map[x][right] = 2;
                stack.push(new int[]{x, right});
                size++;
            }
        }
        return size;
    }

}
