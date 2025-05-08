package problems.programmers;

/* 
 * Programmers 43165 - 타겟 넘버
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class N43165 {
    private int totalWays = 0;

    public int solution(int[] numbers, int target) {
        totalWays = 0; // 여러 테스트 시 재사용 가능하도록 초기화
        dfs(numbers, target, 0, 0);
        return totalWays;
    }

    private void dfs(int[] numbers, int target, int index, int currentSum) {
        if (index == numbers.length) {
            if (currentSum == target) {
                totalWays++;
            }
            return;
        }

        // 현재 수를 더하거나 빼며 재귀 탐색
        dfs(numbers, target, index + 1, currentSum + numbers[index]);
        dfs(numbers, target, index + 1, currentSum - numbers[index]);
    }
}
