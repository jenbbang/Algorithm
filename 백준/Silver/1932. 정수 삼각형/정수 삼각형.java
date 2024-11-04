import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N][];
        
        // 삼각형 데이터 입력
        for (int i = 0; i < N; i++) {
            triangle[i] = new int[i + 1];
            String[] input = br.readLine().split(" ");
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(input[j]);
            }
        }

        // DP 배열 초기화
        int[][] dp = new int[N][];
        for (int i = 0; i < N; i++) {
            dp[i] = new int[i + 1];
        }

        // 첫 번째 행 초기화
        dp[0][0] = triangle[0][0];

        // DP 계산
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j]; // 맨 왼쪽
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j]; // 맨 오른쪽
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j]; // 가운데
                }
            }
        }

        // 결과 계산: 마지막 행의 최대값
        int maxSum = 0;
        for (int j = 0; j < N; j++) {
            maxSum = Math.max(maxSum, dp[N - 1][j]);
        }

        System.out.println(maxSum);
    }
}
