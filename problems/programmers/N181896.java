package problems.programmers;

/* Programmers 181896 - 첫 번째로 나오는 음수
 * https://school.programmers.co.kr/learn/courses/30/lessons/181896
 */
public class N181896 {
    public int solution(int[] num_list) {
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
