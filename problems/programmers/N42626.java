package problems.programmers;

import java.util.PriorityQueue;

/* 
 * Programmers 42626 - 더 맵게
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class N42626 {
    public int solution(int[] scoville, int K) {
        // 섞은 횟수를 저장할 변수
        int mixCount = 0;

        // 스코빌 지수를 기준으로 오름차순 정렬되는 우선순위 큐
        PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>();

        // 초기 스코빌 지수 배열을 우선순위 큐에 모두 추가
        for (int spiceLevel : scoville) {
            scovilleQueue.offer(spiceLevel);
        }

        // 가장 매운 음식의 스코빌 지수가 K 이상이 될 때까지 반복
        while (!scovilleQueue.isEmpty() && scovilleQueue.peek() < K) {
            // 더 이상 섞을 수 없는 경우 - 실패 조건
            if (scovilleQueue.size() < 2) {
                return -1;
            }

            // 가장 맵지 않은 두 음식을 꺼내서 새로운 음식을 만든다
            int leastSpicy = scovilleQueue.poll();
            int secondLeastSpicy = scovilleQueue.poll();
            int mixedSpice = leastSpicy + (secondLeastSpicy * 2);

            // 새로운 음식을 다시 큐에 추가
            scovilleQueue.offer(mixedSpice);
            mixCount++;
        }

        // 모든 음식의 스코빌 지수가 K 이상이 된 횟수 반환
        return mixCount;
    }
}
