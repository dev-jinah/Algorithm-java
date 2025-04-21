package problems.programmers;

import java.util.Arrays;

/* 
 * Programmers 42747 - H-Index
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */
public class N42747 {
    public int solution(int[] citations) {
        // 예외 처리: null이거나 비어 있는 배열인 경우 h-index는 0
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        // 논문 인용 횟수를 오름차순 정렬
        Arrays.sort(citations);

        int hIndex = 0;

        // 뒤에서부터 순회하면서 h-index 조건을 만족하는 최대값 찾기
        for (int i = citations.length - 1; i >= 0; i--) {
            // 현재 논문의 인용 횟수와, 해당 논문보다 많이 인용된 논문 수 중 작은 값 계산
            int candidate = Math.min(citations[i], citations.length - i);

            // 현재까지의 최대 h-index보다 크면 갱신
            if (hIndex < candidate) {
                hIndex = candidate;
            }
        }

        return hIndex;
    }
}
