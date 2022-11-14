package practice.programmers.reduceString;

public class ReduceString60057_3 {
    public static void main(String[] args) {
        System.out.println(solution("abcabcabcabcdededededede"));
    }

    static int solution(String input){
        int length = input.length();
        int answer = length;

        for(int size = 1; size < (length/2 + 1); size++){
            int cp = 0;
            int cep = cp + size;
            int nep = cep + size;
            String working = "";
            int count = 1;

            while(true){

                if (cep <= length) {

                    if(nep <= length){

                        if(input.substring(cp, cep).equals(input.substring(cep, nep))){
                            count++;
                        }else{

                            if(count == 1){
                                working += input.substring(cp, cep);
                            }else{
                                working += (count + input.substring(cp, cep));
                            }
                            count = 1;

                        }

                    }else{
                        working += ifCount(input, count, cp);
                        break;
                    }

                } else {
                    working += ifCount(input, count, cp);
                    break;
                }
                cp = cep;
                cep = nep;
                nep += size;
            }
            int compare = working.length();

            if(compare <= answer){
                answer = compare;
            }
        }
        return answer;
    }

    static String ifCount(String original, int count, int from){
        String piece = original.substring(from);

        if (count == 1) {
            return piece;
        } else {
            return count + piece;
        }

    }
}
