package problems.programmers;

import java.util.HashMap;
import java.util.Map;


/**
 * Programmers 42576 - 완주하지 못한 선수 (Uncompleted Marathoner)
 * 
 * 문제 설명:
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participants,
 * 완주한 선수들의 이름이 담긴 배열 completions이 주어질 때,
 * 완주하지 못한 선수의 이름을 반환하는 문제입니다.
 *
 * 문제 조건:
 * - 참가자 중 한 명이 완주하지 못했습니다.
 * - 동명이인이 있을 수 있습니다.
 */

public class N42576 {

    public static String solution(String[] participants, String[] completions) {

        Map<String, Integer> participantCountMap = new HashMap<>();

        // 참가자 목록을 map에 저장 (이름별 카운트)
        for (String participant : participants) {
            participantCountMap.put(participant, participantCountMap.getOrDefault(participant, 0) + 1);
        }

        // 완주한 사람 -1 (완주자의 이름 수만큼 참가자 수에서 차감)
        for (String completion : completions) {
            participantCountMap.put(completion, participantCountMap.getOrDefault(completion,0) - 1);
        }

        // 값이 1인 사람이 완주 못한 사람 (값이 0이 아닌 사람(=완주하지 못한 사람)을 찾아 반환)
        for (String name : participantCountMap.keySet()) {
            if (participantCountMap.get(name) == 1) {
                return name;
            }
        }

        // 문제 조건상 경우는 발생하지 않음
        return null;
    }

    public static void main(String[] args) {

        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa", "vinko"}, new String[]{"josipa", "filipa", "marina", "vinko","nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
    
}
