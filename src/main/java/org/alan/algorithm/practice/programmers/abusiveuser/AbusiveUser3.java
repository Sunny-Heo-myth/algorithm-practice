package org.alan.algorithm.practice.programmers.abusiveuser;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class AbusiveUser3 {
    private Set<Set<String>> answer;
    private String[] userIds;
    private String[] bannedIds;

    public int solution(String[] user_id, String[] banned_id) {
        answer = new HashSet<>();
        this.userIds = user_id;
        this.bannedIds = banned_id;

        dfs(new LinkedHashSet<>());

        return answer.size();
    }


    private void dfs(Set<String> set) {
        if (set.size() == bannedIds.length) {
            if (isBanList(set)) {
                answer.add(new HashSet<>(set));
            }
            return;
        }

        for (String userId : userIds) {
            if (set.add(userId)) {
                dfs(set);
                set.remove(userId);
            }
        }
    }


    private boolean isBanList(Set<String> set) {
        int idx = 0;
        for (String user : set) {   // How does this work??
            String banned = bannedIds[idx++];
            if (user.length() != banned.length()) {
                return false;
            }
            for (int i = 0; i < banned.length(); i++) {
                if (banned.charAt(i) == '*') {
                    continue;
                }
                if (user.charAt(i) != banned.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
