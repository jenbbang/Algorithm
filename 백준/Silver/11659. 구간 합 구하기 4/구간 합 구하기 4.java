import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄 입력: N (수의 개수), M (합을 구해야 하는 횟수)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 수 배열
        int[] arr = new int[N + 1]; // 1-based index 사용 위해 크기 N+1
        
        // 누적 합 배열
        int[] prefixSum = new int[N + 1];
        
        // 두 번째 줄 입력: N개의 수
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + arr[i]; // 누적 합 계산
        }
        
        // M개의 구간에 대한 합을 구하는 부분
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            // 구간 [start, end]의 합 출력
            System.out.println(prefixSum[end] - prefixSum[start - 1]);
        }
    }
}
