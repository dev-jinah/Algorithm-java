package problems.programmers;

/* Programmers 181938 - 두 수의 연산값 비교하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181938
 */
public class N181938 {
    public int solution(int a, int b) {
        int num1 = Integer.parseInt(String.valueOf(a) + String.valueOf(b)); // 두 수를 붙여서 정수로 변환
        int num2 = 2 * a * b; // 2 * a * b 계산
        return Math.max(num1, num2); // 둘 중 더 큰 값 반환
    }
    
}
