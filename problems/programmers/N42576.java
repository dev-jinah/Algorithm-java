package problems.programmers;

import java.util.HashMap;
import java.util.Map;

public class N42576 {

    public static String solution(String[] participants, String[] completions) {

        Map<String, Integer> participantCountMap = new HashMap<>();

        // 참가자 목록을 map에 저장 (이름별 카운트)
        for (String participant : participants) {
            participantCountMap.put(participant, participantCountMap.getOrDefault(participant, 0) + 1);
        }

        // 완주한 사람 -1
        for (String completion : completions) {
            participantCountMap.put(completion, participantCountMap.getOrDefault(completion,0) - 1);
        }

        // 값이 1인 사람이 완주 못한 사람
        for (String name : participantCountMap.keySet()) {
            if (participantCountMap.get(name) == 1) {
                return name;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
    
}
