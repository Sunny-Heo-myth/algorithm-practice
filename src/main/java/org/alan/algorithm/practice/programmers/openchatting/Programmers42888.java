package org.alan.algorithm.practice.programmers.openchatting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Programmers42888 {

    public static void main(String[] args) {
        String[] x = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        for(String s : solution(x)){
            System.out.println(s);
        }
    }

    static String[] solution(String[] record) {
        int length = record.length;
        String[][] revise = new String[length][3];
        HashMap<String, String> idNickHashMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String[] x = record[i].split(" ");
            revise[i][0] = x[0];
            revise[i][1] = x[1];
            if(x.length == 3){
                revise[i][2] = x[2];
            }
        }
        List<String[]> log = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            String state = revise[i][0];
            String id = revise[i][1];
            String nick = revise[i][2];

            switch (state) {
                case "Enter" :
                    idNickHashMap.put(id, nick);
                    log.add(revise[i]);
                    break;
                case "Change" :
                    idNickHashMap.put(id, nick);
                    break;
                case "Leave" :
                    log.add(revise[i]);
                    break;
            }
        }
        int logSize = log.size();
        String[] answer = new String[logSize];
        for (int i = 0; i < logSize; i++) {
            String state = log.get(i)[0];
            String nick = log.get(i)[2];
            if (state.equals("Enter")) {
                answer[i] = idNickHashMap.get(log.get(i)[1]) + "님이 들어왔습니다.";
            } else if (state.equals("Leave")) {
                answer[i] = idNickHashMap.get(log.get(i)[1]) + "님이 나갔습니다.";
            }
        }
        return answer;
    }

}
