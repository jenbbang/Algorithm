import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]); // 물건의 수
        int K = Integer.parseInt(inputs[1]); // 배낭의 최대 무게
        
        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];
        int[][] dp = new int[N + 1][K + 1];

        // 물건의 정보 입력
        for (int i = 1; i <= N; i++) {
            String[] item = br.readLine().split(" ");
            weights[i] = Integer.parseInt(item[0]);
            values[i] = Integer.parseInt(item[1]);
        }

        // DP 테이블 채우기
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                if (weights[i] > j) {
                    dp[i][j] = dp[i - 1][j]; // 현재 물건을 넣을 수 없으면 이전 값을 가져옴
                } else {
                    // 현재 물건을 넣는 경우와 넣지 않는 경우 중 큰 값 선택
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
