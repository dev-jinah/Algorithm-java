package problems.programmers;

import java.util.HashSet;

/* Programmers 1845 - 폰켓몬
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 * 
 * 풀이 요약
 * - N/2마리만 선택 가능.
 * - 종류가 최대한 다양해야 하므로 중복 제거(set)를 사용.
 * - set의 크기와 N/2 중 작은 값이 정답.
 */
public class N1845 {
    public static int solution(int[] nums) {

        int answer = 0;
        int max = nums.length / 2;

        // 중복 제거
        HashSet<Integer> numsSet = new HashSet<>();

        for (int num : nums) {
            numsSet.add(num);
        }

        // 셋의 크기가 max보다 크면 max, 작으면 numsSet의 size를 리턴
        if(numsSet.size() > max) {
            answer = max;
        } else {
            answer = numsSet.size();
        }

        return answer;
    }

    // 예시 테스트
    public static void main(String[] args) {

        System.out.println(solution(new int[]{3, 1, 2, 3}));
        System.out.println(solution(new int[]{3,3,3,2,2,4}));
        System.out.println(solution(new int[]{3,3,3,2,2,2}));
    }
}
