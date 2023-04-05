package org.alan.algorithm.practice.programmers.reducestring;

public class ReduceString60057 {
    public static int solution(String input) {
        int length = input.length();
        int answer = length;

        for (int i = 1; i < length; i++) {
            StringBuilder builder = new StringBuilder();

            int cp = 0;
            int cep = cp + i;
            int nep = cep + i;
            int count = 1;

            while (true) {
                String subString = input.substring(cp, cep);

                if (cep > length) {
                    builder.append(input.substring(cp));
                    answer = Math.min(answer, builder.length());
                    break;
                }

                if (nep <= length && subString.equals(input.substring(cep, nep))) {
                    count++;
                } else {
                    String tmp = count == 1 ? subString : count + subString;
                    builder.append(tmp);
                    count = 1;
                }

                if (nep > length) {
                    builder.append(input.substring(cep));
                    answer = Math.min(answer, builder.length());
                    break;
                }

                cp = cep;
                cep = nep;
                nep = nep + i;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution("aaabbbccccccccccc"));
    }
}
