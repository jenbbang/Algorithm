import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // n이 1인 경우는 방법이 1개
        if (n == 1) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[n + 1];

        // 초기 값 설정
        dp[1] = 1; // 2x1 크기의 직사각형을 채우는 방법은 1가지
        dp[2] = 2; // 2x2 크기의 직사각형을 채우는 방법은 2가지

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007; // 문제의 조건에 따라 10007로 나눈 나머지
        }

        // 결과 출력
        System.out.println(dp[n]);
    }
}
