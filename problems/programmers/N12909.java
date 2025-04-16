package problems.programmers;

import java.util.Stack;

/*
 * Programmers 12909 - 올바른 괄호 (Correct Brackets)
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class N12909 {
    boolean solution(String s) {
        if (s == null || s.isEmpty()) {
            System.out.println("s 값을 확인해주세요");
            return false;
        }

        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        // 문자열을 한 글자씩 순회
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            // 여는 괄호 '('일 경우 스택에 추가
            if(c == '('){
                stack.push(c);
            }
            
            // 닫는 괄호 ')'일 경우
            if(c == ')'){
                // 스택이 비어 있다면, 매칭될 여는 괄호가 없다는 뜻 → 올바르지 않음
                if(stack.size() == 0){
                    return false;
                }
                // 매칭되는 여는 괄호 하나 제거
                else stack.pop();
            }
        }
        // 모든 괄호를 처리한 뒤 스택이 비어있지 않다면 → 여는 괄호가 남아있다는 뜻
        if(stack.size() != 0) answer = false;

        return answer;
    }
    
    public static void main(String[] args) {
        N12909 checker = new N12909();

        // 테스트 케이스들
        System.out.println("Test 1: " + checker.solution("()()"));     // true
        System.out.println("Test 2: " + checker.solution("(())()"));   // true
        System.out.println("Test 3: " + checker.solution(")("));       // false
        System.out.println("Test 4: " + checker.solution("(()("));     // false
        System.out.println("Test 5: " + checker.solution(""));         // false + 안내 메시지
        System.out.println("Test 6: " + checker.solution(null));       // false + 안내 메시지
    }
}
