package org.alan.algorithm.practice.programmers.abusiveuser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbusiveUser {
    private String[] bannedIds;
    private boolean[] userIdCheck;
    Map<String, List<Integer>> matching;
    private int result = 0;

    public int solution(String[] userIds, String[] bannedIds) {
        this.bannedIds = bannedIds;
        this.userIdCheck = new boolean[userIds.length];
        matching = new HashMap<>();

        for (String bannedId : bannedIds) {
            matching.put(bannedId, new ArrayList<>());
            for (int i = 0; i < userIds.length; i++) {
                String userId = userIds[i];
                if (userId.length() == bannedId.length() && match(userIds[i], bannedId)) {
                    matching.get(bannedId).add(i);
                }
            }
        }

        dfs(0);
        return result;
    }

    private void dfs(int bannedIdx) {
        if (bannedIdx == bannedIds.length) {
            result++;
            return;
        }

        List<Integer> match = matching.get(bannedIds[bannedIdx]);
        for (Integer i : match) {
            if (!userIdCheck[i]) {
                userIdCheck[i] = true;
                dfs(bannedIdx + 1);
                userIdCheck[i] = false;
            }
        }

    }
    private boolean match(String userId, String bannedId) {
        for (int i = 0; i < bannedId.length(); i++) {
            char u = userId.charAt(i);
            char b = bannedId.charAt(i);
            if (b != '*' && b != u) {
                return false;
            }
        }
        return true;
    }
}

