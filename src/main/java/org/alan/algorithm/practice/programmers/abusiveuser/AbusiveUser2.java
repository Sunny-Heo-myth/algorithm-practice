package org.alan.algorithm.practice.programmers.abusiveuser;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class AbusiveUser2 {
    private String[] userIds;
    private String[] bannedIds;
    private final Set<Set<String>> answer = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        this.userIds = user_id;
        this.bannedIds = banned_id;

        dfs(new LinkedHashSet<>());
        return answer.size();
    }

    private void dfs(Set<String> candidate) {
        if (candidate.size() == bannedIds.length) {
            if (qualified(candidate)) {
                answer.add(new HashSet<>(candidate));
            }
            return;
        }

        for (String userId : userIds) {
            if (candidate.add(userId)) {
                dfs(candidate);
                candidate.remove(userId);
            }
        }
    }

    private boolean qualified( Set<String> userIds) {
        int idx = 0;
        for (String userId : userIds) {
            String bannedId = bannedIds[idx++];
            if (userId.length() != bannedId.length()) {
                return false;
            }

            for (int i = 0; i < bannedId.length(); i++) {
                if (bannedId.charAt(i) == '*') {
                    continue;
                }
                if (bannedId.charAt(i) != bannedId.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
