import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[][] dp = new int[2][100001];
        int[][] input = new int[2][100001];

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= N; k++) {
                    input[j][k] = sc.nextInt();
                }
            }

            dp[0][1] = input[0][1];
            dp[1][1] = input[1][1];
            for (int j = 2; j <= N; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + input[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + input[1][j];
            }
            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}
