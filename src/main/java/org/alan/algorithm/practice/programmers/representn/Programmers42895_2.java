package org.alan.algorithm.practice.programmers.representn;

public class Programmers42895_2 {

    static int answer = -1;
    static int countCal = 0;

    public static void main(String[] args) {
        int N = 5;
        int number = 45;
        System.out.println(solution(N, number));
        System.out.println(countCal);
    }

    public static int solution(int N, int number) {
        // dfs recursion with N, number, count, sum
        dfs(N, number, 0, 0);
        return answer;
    }

    public static void dfs(int N, int number, int count, int sum) {
        countCal++;
        if (count > 4) {
            return;
        }
        if (number == sum) {
            if (answer == -1) {
                answer = count;
            } else {
                answer = Math.min(answer, count);
            }
        }
        int X = N;
        for (int i = 1; i <= 4 - count; i++) {
            dfs(N, number, i + count, sum + X);
            dfs(N, number, i + count, sum - X);
            dfs(N, number, i + count, sum * X);
            dfs(N, number, i + count, sum / X);
            X = (10 * X) + N;
        }

    }

}