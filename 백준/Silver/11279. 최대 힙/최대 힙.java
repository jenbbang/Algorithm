import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Collections.reverseOrder()를 사용하여 최대 힙으로 동작하도록 설정
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) {
                if (pq.isEmpty()) { // 우선순위 큐가 비어있으면 0을 출력
                    System.out.println(0);
                } else { // 우선순위 큐가 비어있지 않다면, 최대값을 출력하고 제거
                    System.out.println(pq.poll());
                }
            } else { // num를 우선순위 큐에 추가
                pq.offer(num);
            }
        }
    }
}