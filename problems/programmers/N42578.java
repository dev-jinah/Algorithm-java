package problems.programmers;

import java.util.HashMap;

/* Programmers 42578 - 의상
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
public class N42578 {
    public int solution(String[][] clothes) {
        // 예외 처리: 입력이 null이거나 길이가 0이면, 입을 옷이 없는 것이므로 0을 반환
        if (clothes == null || clothes.length == 0) {
            return 0;
        }

        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        // 의상의 종류별 개수를 HashMap에 저장
        for (String[] c : clothes) {
            String type = c[1]; // 의상 종류 (예: "headgear", "eyewear")
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        // 각 종류별로 의상을 하나도 안 입는 경우까지 고려해 곱함
        for (int count : map.values()) {
            answer *= (count + 1); // (의상 수 + 1) : 안 입는 경우 포함
        }

        // 아무것도 안 입는 경우(전부 안 입음)는 제외해야 하므로 -1
        return answer - 1;
    }
    
    public static void main(String[] args) {
        N42578 solver = new N42578();

        // Test Case 1
        String[][] clothes1 = {
            {"yellowhat", "headgear"},
            {"bluesunglasses", "eyewear"},
            {"green_turban", "headgear"}
        };
        System.out.println("Test Case 1 Result: " + solver.solution(clothes1)); // Expected: 5

        // Test Case 2
        String[][] clothes2 = {
            {"crowmask", "face"},
            {"bluesunglasses", "face"},
            {"smoky_makeup", "face"}
        };
        System.out.println("Test Case 2 Result: " + solver.solution(clothes2)); // Expected: 3

        // Test Case 3
        String[][] clothes3 = {
            {"bluejeans", "pants"}
        };
        System.out.println("Test Case 3 Result: " + solver.solution(clothes3)); // Expected: 1

        // Test Case 4 (empty)
        String[][] clothes4 = {};
        System.out.println("Test Case 4 Result: " + solver.solution(clothes4)); // Expected: 0
        
        // Test Case 5 (null)
        String[][] clothes5 = null;
        System.out.println("Test Case 5 Result: " + solver.solution(clothes5)); // Expected: 0
    }
}
