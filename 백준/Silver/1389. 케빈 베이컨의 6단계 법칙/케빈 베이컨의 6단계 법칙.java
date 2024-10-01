import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 유저의 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
        int[][] dist = new int[N + 1][N + 1];
        
        // 초기화: 충분히 큰 값으로 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    dist[i][j] = 0; // 자기 자신은 0
                } else {
                    dist[i][j] = 1000000; // 임의의 큰 수로 초기화
                }
            }
        }
        
        // 친구 관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            dist[A][B] = 1; // 친구 관계는 거리 1
            dist[B][A] = 1; // 양방향
        }
        
        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        // 케빈 베이컨의 수가 가장 작은 사람 찾기
        int minPerson = -1;
        int minSum = Integer.MAX_VALUE;
        
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += dist[i][j];
            }
            if (sum < minSum) {
                minSum = sum;
                minPerson = i;
            }
        }
   
        System.out.println(minPerson);
    }
}