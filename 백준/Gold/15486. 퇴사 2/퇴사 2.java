import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(reader.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 2]; // N + 2로 설정하여 마지막 날 상담을 고려

        // 상담의 기간과 이익 입력 받기
        for (int i = 1; i <= N; i++) {
            String[] input = reader.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }

        // 동적 프로그래밍을 통한 최대 이익 계산
        for (int i = 1; i <= N; i++) {
            // 상담을 하지 않는 경우
            dp[i] = Math.max(dp[i], dp[i - 1]);
            // 상담을 하는 경우
            if (i + T[i] - 1 <= N) {
                dp[i + T[i] - 1] = Math.max(dp[i + T[i] - 1], dp[i - 1] + P[i]);
            }
        }

        // 최대 이익 출력
        int maxProfit = Math.max(dp[N], dp[N + 1]);
        System.out.println(maxProfit);
        
        reader.close();
    }
}
