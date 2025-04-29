package problems.programmers;

import java.util.ArrayList;
import java.util.List;

/* 
 * Programmers 42840 - 모의고사
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */
public class N42840 {
    public int[] solution(int[] answers) {
        // 각 수포자의 정답 패턴
        int[] student1Pattern = {1, 2, 3, 4, 5};
        int[] student2Pattern = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3Pattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 수포자별 정답 개수 저장
        int[] correctCounts = new int[3];

        // 정답과 비교하여 각 수포자의 정답 수 계산
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1Pattern[i % student1Pattern.length]) {
                correctCounts[0]++;
            }
            if (answers[i] == student2Pattern[i % student2Pattern.length]) {
                correctCounts[1]++;
            }
            if (answers[i] == student3Pattern[i % student3Pattern.length]) {
                correctCounts[2]++;
            }
        }

        // 가장 높은 점수 계산
        int highestScore = Math.max(correctCounts[0], 
                              Math.max(correctCounts[1], correctCounts[2]));

        // 가장 높은 점수를 받은 수포자 번호 리스트에 추가
        List<Integer> topScorers = new ArrayList<>();
        for (int i = 0; i < correctCounts.length; i++) {
            if (correctCounts[i] == highestScore) {
                topScorers.add(i + 1); // 수포자는 1번부터 시작
            }
        }

        // List<Integer> → int[] 변환
        int[] result = new int[topScorers.size()];
        for (int i = 0; i < topScorers.size(); i++) {
            result[i] = topScorers.get(i);
        }

        return result;
    }
}
