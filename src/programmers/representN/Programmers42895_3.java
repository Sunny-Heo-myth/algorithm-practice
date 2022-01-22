package programmers.representN;

public class Programmers42895_3 {

    static int answer = -1;

    public static void main(String[] args) {

    }

    public static int solution(int N, int number) {

        return answer;
    }

    public static void dfs(int N, int number, int count, int sum) {
        if (count > 8) {
            return;
        }

        if (sum == number) {
            if (answer == -1) {
                answer = count;
            } else {
                answer = Math.min(answer, count);
            }
        }

        int X = N;
        for (int i = 0; i < 8 - count; i++) {
            dfs(N, number, i + count, sum + X);
            dfs(N, number, i + count, sum - X);
            dfs(N, number, i + count, sum * X);
            dfs(N, number, i + count, sum / X);
            X = (10 * X) + N;
        }
    }
}
