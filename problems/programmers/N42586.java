package problems.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/* 
 * Programmers 42586 - 기능개발 (Function Development)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */
public class N42586 {
    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // 각 작업의 완료까지 남은 일수를 계산하여 큐에 저장
        for (int i = 0; i < progresses.length; i++) {
            int remainingDays = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            queue.addLast(remainingDays);
        }
        
        // 큐를 순회하며 배포 처리
        while (!queue.isEmpty()) {
            int firstNum = queue.pollFirst(); // 첫 번째 작업의 남은 일수
            int sum = 1; // 현재 배포에 포함될 작업 수
            
            // 다음 작업들이 첫 번째 작업과 함께 배포 가능한지 확인
            while (!queue.isEmpty() && queue.peekFirst() <= firstNum) {
                queue.pollFirst();
                sum++;
            }
            answerList.add(sum); // 배포 그룹의 크기 저장
        }

        // ArrayList -> int[] 변환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        int[] result1 = solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        System.out.println("Result 1: " + Arrays.toString(result1)); // [2, 1]

        // 테스트 케이스 2
        int[] result2 = solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
        System.out.println("Result 2: " + Arrays.toString(result2)); // [1, 3, 2]
    }
}
