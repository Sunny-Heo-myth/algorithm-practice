package programmers.lv2.reduceString;

public class ReduceString60057_2 {

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
                String lastString = input.substring(cep);

                if (lastString.startsWith(subString)) {
                    count++;
                } else {
                    String tmp = count == 1 ? subString : count + subString;
                    builder.append(tmp);
                    count = 1;
                }

                if (nep > length) {
                    builder.append(lastString);
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
}
