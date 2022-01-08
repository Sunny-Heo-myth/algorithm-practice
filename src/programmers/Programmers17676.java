package programmers;

public class Programmers17676 {

    public static void main(String[] args) {
        String[] test2 = {
        "2016-09-15 01:00:04.002 2.0s",
            "2016-09-15 01:00:07.000 2s"
        };

        String[] test = {
        "2016-09-15 20:59:57.421 0.351s",
            "2016-09-15 20:59:58.233 1.181s",
            "2016-09-15 20:59:58.299 0.8s",
            "2016-09-15 20:59:58.688 1.041s",
            "2016-09-15 20:59:59.591 1.412s",
            "2016-09-15 21:00:00.464 1.466s",
            "2016-09-15 21:00:00.741 1.581s",
            "2016-09-15 21:00:00.748 2.31s",
            "2016-09-15 21:00:00.966 0.381s",
            "2016-09-15 21:00:02.066 2.62s"
        };
        System.out.println(solution(test));
    }

    static int solution(String[] lines) {
        int length = lines.length;
        int[][] ints = new int[length][2];

        for (int i = 0; i < length; i++) {
            String[] s = lines[i].split(" ");
            String[] time = s[1].split(":");
            ints[i][0] = Integer.parseInt(time[0]) * 60 * 60 * 1000 +
                Integer.parseInt(time[1]) * 60 * 1000 +
                (int) Math.ceil(Float.parseFloat(time[2]) * 1000);
            ints[i][1] = (int) (Float.parseFloat(s[2].substring(0, s[2].length() - 1)) * 1000);
        }
        int maxProcess = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            int process = 1;
            int pEndAt = ints[i][0];
            for (int j = i + 1; j < length; j++) {
                int nextPStartAt = ints[j][0] - ints[j][1] + 1;
                int nextPEndAt = ints[j][0];
                if (pEndAt > nextPEndAt || pEndAt + 999 < nextPStartAt) continue;
                process++;
            }
            if (process > maxProcess) maxProcess = process;
        }
        return maxProcess;
    }
}
