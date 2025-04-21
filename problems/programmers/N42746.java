package problems.programmers;

import java.util.Arrays;

/* 
 * Programmers 42746 - 가장 큰 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */
public class N42746 {
    public String solution(int[] numbers) {
        // 정렬된 배열을 이어붙여 최종 결과 생성
        StringBuilder answer = new StringBuilder();

        // 예외 처리: null이거나 비어 있는 배열인 경우 0 반환
        if (numbers == null || numbers.length == 0) {
            return answer.toString();
        }

        // 정수를 문자열 배열로 변환
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 문자열을 조합했을 때 더 큰 수가 되도록 정렬
        // 예: "9" + "30" vs "30" + "9" → "930" vs "309" → "930"이 더 크므로 "9"가 앞에
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        // 정렬 후 가장 앞자리가 0이면 전체 숫자가 0으로 구성된 것이므로 "0" 반환
        if (arr[0].equals("0")) {
           return "0";
        }

        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }

        return answer.toString();
    }
}
