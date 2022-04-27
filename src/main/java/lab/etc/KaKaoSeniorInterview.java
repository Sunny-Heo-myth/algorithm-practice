package lab.etc;

import java.util.*;

public class KaKaoSeniorInterview {

    public static void main(String[] args) {
        List<Integer> x = solution1(8, Arrays.asList(8,3,8,5,1,8), Arrays.asList(100, 2, 1));
        System.out.println(x);
    }

    static List<Integer> solution1(int value, List<Integer> targetList, List<Integer> ordinalList) {
        Map<Integer, Integer> ordinalIndexMap = new HashMap<>();
        int ordinal = 1;
        for (int i = 0; i < targetList.size(); i++) {
            if (targetList.get(i) == value) {
                ordinalIndexMap.put(ordinal++, i + 1);
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (Integer i : ordinalList) {
            answer.add(ordinalIndexMap.getOrDefault(i, -1));
        }
        return answer;
    }

//    static int solution3(int numberOfHouse, List<Integer> houseList) {
//
//    }
}
