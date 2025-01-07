import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        // 최대 n의 범위
        int maxN = 1000000;
        long[] dp = new long[maxN + 1];
        final int MOD = 1000000009;

        // 초기값 설정
        dp[0] = 1; // dp[0]은 1로 설정 (아무것도 선택하지 않음)
        dp[1] = 1; // 1
        dp[2] = 2; // 1+1, 2
        dp[3] = 4; // 1+1+1, 1+2, 2+1, 3

        // 동적 프로그래밍으로 dp 배열 채우기
        for (int i = 4; i <= maxN; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
    }
}
