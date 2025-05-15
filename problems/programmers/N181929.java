package problems.programmers;

/* 
 * Programmers 181929 - 원소들의 곱과 합
 * https://school.programmers.co.kr/learn/courses/30/lessons/181929?language=java
 */
public class N181929 {
    public int solution(int[] num_list) {
        int sumOfElements = 0;
        int productOfElements = 1;
        
        for (int num : num_list) {
            sumOfElements += num;
            productOfElements *= num;
        }
        
        return (sumOfElements * sumOfElements > productOfElements) ? 1 : 0;
    }
}
