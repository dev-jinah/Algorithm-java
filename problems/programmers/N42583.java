package problems.programmers;

import java.util.LinkedList;
import java.util.Queue;

/* Programmers 42583 - 다리를 지나는 트럭 (Truck Passing a Bridge)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583
 */
public class N42583 {
    public static int solution(int bridgeLength, int maxWeight, int[] truckWeights) {
        if (truckWeights == null || truckWeights.length == 0) {
            System.out.println("truckWeights 값이 없습니다.");
            return 0;
        }
        if (bridgeLength <= 0 || maxWeight <= 0) {
            System.out.println("잘못된 입력입니다. (다리 길이와 최대 무게는 1 이상이어야 합니다)");
            return 0;
        }

        Queue<Integer> bridge = new LinkedList<>(); // 다리를 나타내는 큐
        int time = 0; // 경과 시간
        int totalWeightOnBridge = 0; // 현재 다리 위의 총 트럭 무게
        int truckIndex = 0; // 현재 대기 중인 트럭 인덱스

        // 초기 다리 상태: bridgeLength만큼 0으로 채움 (빈 공간 의미)
        for (int i = 0; i < bridgeLength; i++) {
            bridge.offer(0);
        }

        while (!bridge.isEmpty()) {
            time++; // 시간 증가
            totalWeightOnBridge -= bridge.poll(); // 다리를 건넌 트럭 제거

            if (truckIndex < truckWeights.length) {
                int nextTruckWeight = truckWeights[truckIndex];

                // 다음 트럭이 다리에 올라갈 수 있는 경우
                if (totalWeightOnBridge + nextTruckWeight <= maxWeight) {
                    bridge.offer(nextTruckWeight);
                    totalWeightOnBridge += nextTruckWeight;
                    truckIndex++;
                } else {
                    // 트럭이 못 올라가는 경우, 0을 넣어 공간만 채움
                    bridge.offer(0);
                }
            }
        }

        return time;
    }

    public static void main(String[] args) {

        // ✅ 정상 테스트 케이스
        int[] truckWeights1 = {7, 4, 5, 6};
        int bridgeLength1 = 2;
        int maxWeight1 = 10;
        System.out.println("🚚 Result: " + solution(bridgeLength1, maxWeight1, truckWeights1)); // 예상 출력: 8

        // ✅ 예외 테스트 케이스 (빈 배열)
        int[] truckWeights2 = {};
        int bridgeLength2 = 3;
        int maxWeight2 = 15;
        System.out.println("🚫 Result: " + solution(bridgeLength2, maxWeight2, truckWeights2)); // 예상 출력: "값이 없습니다."

        // ✅ null 입력 테스트
        System.out.println("🚫 Result: " + solution(bridgeLength2, maxWeight2, null)); // 예상 출력: "값이 없습니다."
    }
}
