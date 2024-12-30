import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        StringBuilder result = new StringBuilder();
        
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 일수
            long[] prices = new long[N];
            String[] priceStrings = br.readLine().split(" ");
            
            for (int i = 0; i < N; i++) {
                prices[i] = Long.parseLong(priceStrings[i]);
            }
            
            long maxProfit = 0;
            long maxPrice = 0;
            
            // 뒤에서부터 최대 가격을 찾으면서 이익을 계산
            for (int i = N - 1; i >= 0; i--) {
                if (prices[i] > maxPrice) {
                    maxPrice = prices[i]; // 최대 가격 업데이트
                }
                maxProfit += maxPrice - prices[i]; // 이익 계산
            }
            
            result.append(maxProfit).append("\n");
        }
        
        System.out.print(result);
    }
}
