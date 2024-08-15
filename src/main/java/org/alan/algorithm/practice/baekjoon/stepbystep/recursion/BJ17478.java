package org.alan.algorithm.practice.baekjoon.stepbystep.recursion;

import java.util.Scanner;

public class BJ17478 {

    static int repeatingIndent;
    static String indent = "____";
    static String[] recursiveStrings = {
            "\"재귀함수가 뭔가요?\"\n",
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"
    };
    static String recursion = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
    static String endString = "라고 답변하였지.";

    public static void main(String[] args) {
        repeatingIndent = new Scanner(System.in).nextInt();
        int count = repeatingIndent;
        String answer = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
        System.out.print(recursion(count, answer) + endString);
    }

    static String recursion(int n, String answer) {
        if (n == 0) {
            answer += (repeat(repeatingIndent - n) + recursiveStrings[0]);
            answer += (repeat(repeatingIndent - n) + recursion);
            return answer;
        }
        for (String s : recursiveStrings) {
            answer += (repeat(repeatingIndent - n) + s);
        }
        return recursion(n - 1, answer) + (repeat(repeatingIndent + 1 - n) + endString + "\n");
    }

    static String repeat(int n) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            answer += indent;
        }
        return answer;
    }
}
