import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 카드의 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 카드팩 가격 입력
        int[] prices = new int[N + 1];
        String[] inputPrices = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            prices[i] = Integer.parseInt(inputPrices[i - 1]);
        }
        
        // DP 배열 초기화
        int[] dp = new int[N + 1];
        
        // DP를 이용하여 최대 금액 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + prices[j]);
            }
        }
        
        System.out.println(dp[N]);
    }
}
