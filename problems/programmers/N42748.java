package problems.programmers;

import java.util.ArrayList;
import java.util.Collections;

/* 
 * Programmers 42748 - K번째수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */
public class N42748 {
    public int[] solution(int[] array, int[][] commands) {
        // 결과를 담을 배열 생성    
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0]; // 시작 인덱스 (1-based)
            int end = commands[i][1];   // 끝 인덱스 (1-based)
            int k = commands[i][2];     // k번째 숫자 (1-based)

            // 부분 배열을 담을 리스트 생성
            ArrayList<Integer> subList = new ArrayList<>();
  
            // 주어진 범위에서 숫자 추출 (1-based -> 0-based 보정)
            for (int j = start - 1; j < end; j++) {
                subList.add(array[j]);
            }
    
            // 추출한 리스트 오름차순 정렬
            Collections.sort(subList);
            // k번째 숫자를 결과 배열에 저장 (1-based -> 0-based)
            answer[i] = subList.get(k - 1);    
        }
        return answer;    
    }
}
