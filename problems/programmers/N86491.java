package problems.programmers;

/*
 * Programmers 86491 - 최소직사각형 (Minimum Rectangle)
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 */
public class N86491 {
    public int solution(int[][] sizes) {
        // 지갑의 가로와 세로의 최대값을 저장할 변수 초기화
        int maxWidth = 0;
        int maxHeight = 0;
    
        // 모든 명함을 돌면서 가로와 세로 중 큰 값을 가로로, 작은 값을 세로로 정렬
        for (int i = 0; i < sizes.length; i++) {
            // 현재 명함의 가로와 세로 중 큰 값은 가로로 설정
            int width = Math.max(sizes[i][0], sizes[i][1]);
            // 작은 값은 세로로 설정
            int height = Math.min(sizes[i][0], sizes[i][1]);
    
            // 가로 최대값 갱신
            maxWidth = Math.max(maxWidth, width);
            // 세로 최대값 갱신
            maxHeight = Math.max(maxHeight, height);
        }
    
        // 가장 큰 가로, 세로 크기를 곱해서 지갑의 최소 크기 계산
        return maxWidth * maxHeight;
    }
}
