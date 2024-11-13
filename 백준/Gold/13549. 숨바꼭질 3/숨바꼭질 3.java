import java.util.*;

public class Main {
    static final int MAX = 100001; // 최대 위치
    static int[] dist = new int[MAX]; // 거리 배열

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 시작 위치
        int K = scanner.nextInt(); // 목표 위치

        // 거리 배열 초기화
        Arrays.fill(dist, -1);
        
        // BFS를 위한 우선순위 큐 (시간이 적게 걸리는 순서대로 처리)
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        dist[N] = 0; // 시작 위치의 거리
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            // 목표 지점에 도달한 경우
            if (current == K) {
                System.out.println(dist[current]);
                return;
            }
            
            // 순간이동 (거리 0)
            if (current * 2 < MAX && dist[current * 2] == -1) {
                dist[current * 2] = dist[current]; // 현재 거리와 같음
                queue.offer(current * 2);
            }
            
            // 일반 이동 (거리 +1)
            if (current - 1 >= 0 && dist[current - 1] == -1) {
                dist[current - 1] = dist[current] + 1;
                queue.offer(current - 1);
            }
            if (current + 1 < MAX && dist[current + 1] == -1) {
                dist[current + 1] = dist[current] + 1;
                queue.offer(current + 1);
            }
        }
    }
}
