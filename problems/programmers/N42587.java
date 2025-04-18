package problems.programmers;

import java.util.Collections;
import java.util.PriorityQueue;

/* 
 * Programmers 42587 - 프로세스 (process)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 */
public class N42587 {

    public int solution(int[] priorities, int location) {
        // 몇 번째로 해당 프로세스가 실행되는지를 저장할 변수
        int answer = 1;
    
        // 우선순위가 높은 순으로 정렬되도록 내림차순 PriorityQueue 생성
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
          
        // 모든 프로세스를 우선순위 큐에 삽입
        for(int priority : priorities) {
          queue.add(priority);
        }
    
        // 큐가 비워질 때까지 반복
        while(!queue.isEmpty()){
          for(int i = 0; i < priorities.length; i++)
     
            // 현재 큐의 가장 높은 우선순위와 배열의 i번째 우선순위가 같다면
            if(queue.peek() == priorities[i]) {
              // 현재 프로세스가 우리가 찾는 위치(location)라면 종료
              if(i == location) return answer;
    
              // 그렇지 않으면 큐에서 제거하고 실행 순서(answer) 증가
              queue.poll();
              answer++;
            }
        }
    
        return answer;
    }
}
