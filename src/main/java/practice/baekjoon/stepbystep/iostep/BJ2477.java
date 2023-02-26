package practice.baekjoon.stepbystep.iostep;

public class BJ2477 {
    private final int n;
    private final int[][] lineSegment = new int[6][2];

    public BJ2477(String input) {
        String[] lines = input.split("\n");
        n = Integer.parseInt(lines[0]);

        for (int i = 0; i < lines.length - 1; i++) {
            String[] line = lines[i + 1].split(" ");
            lineSegment[i][0] = Integer.parseInt(line[0]);
            lineSegment[i][1] = Integer.parseInt(line[1]);
        }
    }

    public int answer() {
        int[] checker = new int[4];
        for (int[] segment : lineSegment) {
            checker[segment[0] + 1]++;
        }

        int land = 1;
        for (int i = 0; i < checker.length; i++) {
            if (checker[i] == 1) {
                
            }
        }

        return 0;
    }
}
