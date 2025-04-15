package problems.programmers;

import java.util.Arrays;
import java.util.Stack;

/* 
 * Programmers 12906 - 같은 숫자는 싫어 (Remove Consecutive Duplicates)
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 */

public class N12906 {
    public static int[] solution(int []arr) {
        int[] answer = {};

        // 중복 제거된 숫자를 임시로 저장할 스택 생성
        Stack<Integer> stack = new Stack<>();
        
        // 주어진 배열을 순회하며 중복 제거
        for (int i : arr) {
            // 스택이 비어있거나, 현재 값 i가 스택의 마지막 값과 다를 경우에만 추가
            if (stack.empty() || !stack.peek().equals(i)) {
                stack.push(i);
            }
        }
        
        // 스택에 저장된 값을 배열로 변환
        answer = stack.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    public static void main(String[] args) {

        // 테스트 케이스 1
        int[] result1 = solution(new int[]{1, 1, 3, 3, 0, 1, 1});
        System.out.println("Result 1: " + Arrays.toString(result1)); // [1, 3, 0, 1]

        // 테스트 케이스 2
        int[] result2 = solution(new int[]{4, 4, 4, 3, 3});
        System.out.println("Result 2: " + Arrays.toString(result2)); // [4, 3]
    }
}
