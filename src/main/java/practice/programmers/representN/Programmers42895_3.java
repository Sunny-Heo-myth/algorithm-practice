package practice.programmers.representN;

public class Programmers42895_3 {
    static int answer = -1;

    public static void main(String[] args) {
        System.out.print(solution(5, 12));
    }

    public static int solution(int n, int target) {
        dfs(n, target, 0, 0);
        return answer;
    }

    public static void dfs(int n, int target, int count, int sum) {
        if (count > 8) {
            return;
        }
        if (target == sum) {
            if (answer == -1) {
                answer = count;
            } else {
                answer = Math.min(answer, count);
            }
        }

        int concatenated = n;
        for (int i = 1; i <= 8 - count; i++) {
            dfs(n, target, count + i, sum + concatenated);
            dfs(n, target, count + i, sum - concatenated);
            dfs(n, target, count + i, sum * concatenated);
            dfs(n, target, count + i, sum / concatenated);
            concatenated = concatenated*10 + n;
        }
    }
}
