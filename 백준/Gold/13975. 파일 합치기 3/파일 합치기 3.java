import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 수

        for (int i = 0; i < t; i++) {
            int k = sc.nextInt(); // 챕터 수
            PriorityQueue<Long> pq = new PriorityQueue<>(); // 우선순위 큐 생성

            // 모든 챕터의 파일 크기를 우선순위 큐에 추가
            for (int j = 0; j < k; j++) {
                pq.add(sc.nextLong());
            }

            long totalCost = 0; // 총 비용을 저장할 변수
            // 우선순위 큐에 하나의 요소가 남을 때까지 반복
            while (pq.size() > 1) {
                long first = pq.poll(); // 가장 작은 파일 크기 제거
                long second = pq.poll(); // 그 다음으로 작은 파일 크기 제거
                long cost = first + second; // 두 파일을 합치는 비용 계산
                totalCost += cost; // 총 비용에 합치는 비용을 더함
                pq.add(cost); // 합친 파일 크기를 다시 큐에 추가
            }

            // 총 비용 출력
            System.out.println(totalCost);
        }

        // 스캐너 닫기
        sc.close();
    }
}