import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 수

        // 최대 n이 10이므로, 11까지의 dp 배열을 미리 계산
        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // dp 배열을 채움
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        // 각 테스트 케이스에 대해 결과 출력
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}