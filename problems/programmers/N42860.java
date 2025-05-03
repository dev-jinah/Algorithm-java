package problems.programmers;

/*
 * Programmers 42860 - 조이스틱(Joystick)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42860
 */
public class N42860 {
    public int solution(String name) {
        if (name == null || name.isEmpty()) {
            return 0; // 입력이 없을 경우 이동할 필요 없음
        }
        
        int totalMoves = 0;
        int minHorizontalMoves = name.length() - 1; // 초기값은 오른쪽으로 쭉 가는 경우
    
        for (int i = 0; i < name.length(); i++) {
            char currentChar = name.charAt(i);
            
            // 상하 이동 최소값 (A에서 현재 문자까지의 거리 or Z에서 현재 문자까지의 거리 + 1)
            totalMoves += Math.min(currentChar - 'A', 'Z' - currentChar + 1);
    
            // 다음 위치부터 연속된 'A' 위치 계산
            int nextIndex = i + 1;
            while (nextIndex < name.length() && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }
    
            // 좌우 이동 최소값 갱신 (오른쪽 -> 왼쪽 혹은 왼쪽 -> 오른쪽 고려)
            minHorizontalMoves = Math.min(minHorizontalMoves, 
                                          i * 2 + name.length() - nextIndex); // 오른쪽 갔다가 왼쪽
            minHorizontalMoves = Math.min(minHorizontalMoves, 
                                          (name.length() - nextIndex) * 2 + i); // 왼쪽 갔다가 오른쪽
        }
    
        return totalMoves + minHorizontalMoves;
    }    
}
