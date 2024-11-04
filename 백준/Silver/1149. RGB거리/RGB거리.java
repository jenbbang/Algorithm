import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 비용 배열 초기화
        int[][] cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            cost[i][0] = Integer.parseInt(input[0]); // 빨간색 비용
            cost[i][1] = Integer.parseInt(input[1]); // 초록색 비용
            cost[i][2] = Integer.parseInt(input[2]); // 파란색 비용
        }

        // DP 배열 초기화
        int[][] dp = new int[N][3];
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        // DP 계산
        for (int i = 1; i < N; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]); // 빨간색
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]); // 초록색
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]); // 파란색
        }

        int result = Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
        System.out.println(result);
    }
}
