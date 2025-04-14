package problems.programmers;

import java.util.Arrays;

/* Programmers 42577 - 전화번호 목록 (Phone Book)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */

public class N42577 {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // 전화번호 배열을 사전순 정렬 (접두어 관계에 있는 번호들은 정렬 시 서로 인접하게 위치)
        Arrays.sort(phone_book);

        // 인접한 두 전화번호를 비교 (뒤의 번호가 앞의 번호로 시작하는지 확인)
        for (int i = 0; i < phone_book.length - 1; i++) {
            // phone_book[i+1]이 phone_book[i]로 시작하면 접두어 관계가 존재
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false; // 접두어 관계가 있으므로 false 반환
            }
        }

        // 모든 번호를 확인했는데 접두어 관계가 없다면 true 반환
        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"123","456","789"}));
        System.out.println(solution(new String[]{"12","123","1235","567","88"}));
    }
}
