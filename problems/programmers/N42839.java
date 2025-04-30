package problems.programmers;

import java.util.HashSet;
import java.util.Set;

/* 
 * Programmers 42839 - 소수찾기(Prime Number Finder)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */
public class N42839 {
    public static int solution(String numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];

        generatePermutations(numbers, "", visited, uniqueNumbers);

        int primeCount = 0;
        for (int number : uniqueNumbers) {
            if (isPrime(number)) {
                primeCount++;
            }
        }
        return primeCount;
    }

    // 순열 생성 함수
    private static void generatePermutations(String numbers, String currentNumber, boolean[] visited, Set<Integer> resultSet) {
        if (!currentNumber.isEmpty()) {
            resultSet.add(Integer.parseInt(currentNumber));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                generatePermutations(numbers, currentNumber + numbers.charAt(i), visited, resultSet);
                visited[i] = false;  // 백트래킹
            }
        }
    }

    // 소수 판별 함수
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("17"));   // 결과: 3 (7, 17, 71)
        System.out.println(solution("011"));  // 결과: 2 (11, 101)
    }
}
