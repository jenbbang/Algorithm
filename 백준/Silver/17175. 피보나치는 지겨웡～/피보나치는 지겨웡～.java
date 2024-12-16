import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // dp 배열 초기화
        dp = new long[n + 1];
        dp[0] = 1; // F(0) = 1
        if (n > 0) {
            dp[1] = 1; // F(1) = 1
        }
        
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + 1) % MOD; // F(n) = F(n-1) + F(n-2) + 1
        }

        System.out.println(dp[n]);
    }
}
