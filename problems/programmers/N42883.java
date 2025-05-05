package problems.programmers;

/* 
 * Programmers 42883 - 큰 수 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/42883
 */
public class N42883 {
    public String solution(String number, int k) {
        // 최종 결과를 저장할 StringBuilder
        StringBuilder result = new StringBuilder();

        // 다음 탐색을 시작할 인덱스
        int searchStart = 0;

        // 전체 문자열 길이
        int len = number.length();

        // 최종적으로 선택해야 할 숫자의 개수는 (전체 길이 - k)
        for (int i = 0; i < len - k; i++) {
            // 현재 위치에서 선택할 수 있는 범위 내 최대 숫자를 찾기 위해 초기화
            char maxDigit = '0';

            // 현재 위치에서 선택할 수 있는 숫자의 범위는 searchStart부터 (k + i)까지
            // k개의 숫자를 제거할 수 있으므로, 남은 자리 중 가장 큰 수를 선택함
            for (int j = searchStart; j <= k + i; j++) {
                char currentDigit = number.charAt(j);

                // 현재 숫자가 더 크면 maxDigit을 갱신하고, 다음 탐색 시작 위치도 저장
                if (currentDigit > maxDigit) {
                    maxDigit = currentDigit;
                    searchStart = j + 1;

                    // 숫자 중 가장 큰 값이 9이므로 더 볼 필요 없이 탈출
                    if (maxDigit == '9') break;
                }
            }

            // 최대 숫자를 결과에 추가
            result.append(maxDigit);
        }

        // 최종 결과 문자열 반환
        return result.toString();
    }
}
