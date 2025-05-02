package problems.programmers;

import java.util.Arrays;
/*
 * Programmers 42862 - 체육복 (Gym Clothes)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 */
public class N42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n];
    
        // 모든 학생이 기본적으로 체육복을 가진 상태로 초기화
        Arrays.fill(student, 1);
    
    
        // 체육복을 잃어버린 학생 처리
        for (int l : lost) {
            student[l - 1] -= 1;  // 0-based index로 처리
        }
    
        // 여분 체육복을 가진 학생 처리
        for (int r : reserve) {
            student[r - 1] += 1;  // 0-based index로 처리
        }

        // 체육복을 빌려줄 수 있는지 확인
        for (int i = 0; i < n; i++) {
            if (student[i] == 2) {  // 여분의 체육복을 가진 학생
                if (i != 0 && student[i - 1] == 0) {  // 앞 번호 학생에게 빌려줌
                    student[i - 1] = 1;
                    student[i] = 1;
                }
            }
            if (student[i] == 2) {  // 여분의 체육복을 가진 학생
                if (i != n - 1 && student[i + 1] == 0) {  // 뒤 번호 학생에게 빌려줌
                    student[i + 1] = 1;
                    student[i] = 1;
                }
            }
        }

        // 체육복을 입을 수 있는 학생 수 계산
        for (int i = 0; i < n; i++) {
            if (student[i] >= 1) {
                answer++;
            }
        }
        return answer;
    }
}
