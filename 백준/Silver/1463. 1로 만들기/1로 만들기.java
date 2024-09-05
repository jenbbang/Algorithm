import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[1] = 0;  // 1은 이미 1이므로 연산 횟수 0

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;  // 1을 빼는 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);  // 2로 나누는 경우
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);  // 3으로 나누는 경우
            }
        }

        System.out.println(dp[n]);
    }
}
