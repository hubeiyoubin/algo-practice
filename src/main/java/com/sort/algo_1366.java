package com.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yb
 * @date: 2021-3-2
 * 1366 通过投票对团队排名
 */
public class algo_1366 {
    public String rankTeams(String[] votes) {
        HashMap<Character,int[]> rankMap = new HashMap<>();
        for(String str : votes){
            for(int i = 0; i < str.length(); i ++){
                int[] rankArr = rankMap.getOrDefault(str.charAt(i), new int[26]);
                rankArr[i] ++;
                rankMap.put(str.charAt(i), rankArr);
            }
        }
        List<Map.Entry<Character, int[]>> teamRankList = new ArrayList<>(rankMap.entrySet());

        Collections.sort(teamRankList, (team1, team2) -> {
            int[] ranks1 = team1.getValue();
            int[] ranks2 = team2.getValue();
            //根据投票排序
            for (int i = 0; i < 26; i++) {
                if (ranks1[i] != ranks2[i]) {
                    return ranks2[i] - ranks1[i];
                }
            }
            //字母顺序排序
            return team1.getKey() - team2.getKey();
        });

        //转换为字符串输出
        return teamRankList.stream().map(entry -> String.valueOf(entry.getKey())).collect(Collectors.joining());
    }
}
