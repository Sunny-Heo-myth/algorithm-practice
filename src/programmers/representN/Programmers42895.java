package programmers.representN;


public class Programmers42895 {
    static int N;
    static int number;
    static int minimum = -1;
    static StringBuilder temp = new StringBuilder();

    public static void main(String[] args) {
        N = 5;
        number = 12;
        dfs(N, number, 0, 0);
        //System.out.print(minimum);
        System.out.print(temp);
    }


    public static void dfs(int N, int number, int count, int sum) {

        if (count > 4) {
            return;
        }

        temp.append(sum).append("\n");

        if (sum == number) {
            if (minimum == -1) {
                minimum = count;
            } else {
                minimum = Math.min(minimum, count);
            }
        }

        int X = N;
        for (int i = 1; i <= 4 - count; i++) {
            temp.append("\n");
            dfs(N, number, count + i, sum + X);
            dfs(N, number, count + i, sum - X);
            dfs(N, number, count + i, sum * X);
            dfs(N, number, count + i, sum / X);
            X = X*10 + N;
        }
    }
}
