package programmers.lv2.reduceString;

public class ReduceString60057_4 {
    public static void main(String[] args) {
        System.out.println(solution("abbaccc"));
    }

    static int solution(String input){
        int length = input.length();
        int answer = length;
        for(int size = 1; size < (length/2 + 1); size++){
            int startingPoint = 0;
            int endingPoint = startingPoint + size;
            int nextPoint = endingPoint + size;
            int count = 1;
            String workingString = "";
            while(true){

                if (endingPoint <= length) {
                    String currentString = input.substring(startingPoint, endingPoint);

                    if (nextPoint <= length) {
                        String nextString = input.substring(endingPoint, nextPoint);

                        if (currentString.equals(nextString)) {
                            count++;
                        } else {

                            if (count == 1) {
                                workingString += currentString;
                            } else {
                                workingString += count + currentString;
                                count = 1;
                            }

                        }

                    } else {
                        workingString += appendIf(input, count, startingPoint);
                        break;
                    }

                } else {
                    workingString += appendIf(input, count, startingPoint);
                    break;
                }

                startingPoint += size;
                endingPoint += size;
                nextPoint += size;
            }
            int candidate = workingString.length();

            if(candidate <= answer){
                answer = candidate;
            }

        }
        return answer;
    }

    static String appendIf(String s, int count, int p){
        String piece = s.substring(p);

        if (count == 1) {
            return piece;
        } else {
            return count + piece;
        }

    }
}
