package practice.baekjoon.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BJ14502_2 {

    private int[][] lab;
    private int xMax;
    private int yMax;
    private List<int[]> viruses = new ArrayList<>();

    public static BJ14502_2 createInstance(String input) {
        return new BJ14502_2(input);
    }

    public int simulate() {
        int virusTotalCount = viruses.size();
        int[][] simulation = new int[xMax][yMax];
        for (int i = 0; i < xMax; i++) {
            System.arraycopy(lab[i], 0, simulation[i], 0, yMax);
        }

        int[] xMoveArray = {1, 0, -1, 0};
        int[] yMoveArray = {0, 1, 0, -1};
        for (int[] virus : viruses) {
            for (int i = 0; i < 4; i++) {
                Optional<int[]> optional = move(xMoveArray[i], yMoveArray[i], virus);
                if (optional.isPresent() && simulation[optional.get()[0]][optional.get()[1]] == 0) {
                    simulation[optional.get()[0]][optional.get()[1]] = 2;
                    virusTotalCount++;
                }
            }
        }
        return virusTotalCount;
    }

    private Optional<int[]> move(int xTo, int yTo, int[] object) {
        int xTarget = object[0] + xTo;
        int yTarget = object[1] + yTo;
        if (xTarget >= 0 && xTarget < lab.length && yTarget >= 0 && yTarget < lab[0].length) {
            return Optional.of(new int[]{xTarget, yTarget});
        }
        return Optional.empty();
    }

    private BJ14502_2(String input) {
        String[] rows = input.split("\n");
        String[] firstRow = rows[0].split(" ");
        createLab(rows, firstRow);
        findVirus();
    }

    private void createLab(String[] rows, String[] firstRow) {
        xMax = Integer.parseInt(firstRow[0]);
        yMax = Integer.parseInt(firstRow[1]);
        lab = new int[xMax][yMax];
        for (int i = 0; i < xMax; i++) {
            String[] row = rows[i + 1].split(" ");
            for (int j = 0; j < yMax; j++) {
                lab[i][j] = Integer.parseInt(row[j]);
            }
        }
    }

    private void findVirus() {
        for (int i = 0; i < xMax; i++) {
            for (int j = 0; j < yMax; j++) {
                if (lab[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }
    }

}
