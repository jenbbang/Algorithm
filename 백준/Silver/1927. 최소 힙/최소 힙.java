import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) {
                if (pq.isEmpty()) { // 우선순위 큐가 비어있으면 0을 출력
                    System.out.println(0);
                } else { // 우선순위 큐가 비어있지 않다면, 최소값(우선순위 큐의 첫 번째 요소)을 출력하고 제거
                    System.out.println(pq.poll());
                }
            } else { // 입력 값이 0이 아니라면, 우선순위 큐에 해당 숫자를 추가
                pq.add(num);
            }

        }

    }
}