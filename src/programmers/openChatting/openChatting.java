package programmers.openChatting;

import java.util.LinkedList;
import java.util.List;

public class openChatting {

    public static void main(String[] args) {
        String[] x = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        for(String s : solution(x)){
            System.out.println(s);
        }
    }

    static String[] solution(String[] record) {
        int length = record.length;
        String[][] revise = new String[length][3];
        for (int i = 0; i < length; i++) {
            String[] x = record[i].split(" ");
            revise[i][0] = x[0];
            revise[i][1] = x[1];
            if(x.length == 3){
                revise[i][2] = x[2];
            }
        }
        List<String[]> log = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            String state = revise[i][0];
            String id = revise[i][1];
            String nick = revise[i][2];

            switch (state) {
                case "Enter" -> {
                    log.add(revise[i]);
                    changeNick(id, nick, log);
                }
                case "Change" -> changeNick(id, nick, log);
                case "Leave" -> log.add(revise[i]);
            }
        }
        int logSize = log.size();
        String[] answer = new String[logSize];
        for (int i = 0; i < logSize; i++) {
            String state = log.get(i)[0];
            String nick = log.get(i)[2];
            if (state.equals("Enter")) {
                answer[i] = nick + "님이 들어왔습니다.";
            } else if (state.equals("Leave")) {
                answer[i] = nick + "님이 나갔습니다.";
            }
        }
        return answer;
    }

    static void changeNick(String id, String nick, List<String[]> log){
        for (String[] strings : log) {
            String logId = strings[1];
            String logNick = strings[2];
            if (id.equals(logId)) {
                if (!nick.equals(logNick)) {
                    strings[2] = nick;
                }
            }
        }
    }
}
