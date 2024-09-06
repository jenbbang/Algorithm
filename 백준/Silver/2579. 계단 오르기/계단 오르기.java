import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 계단 오르기 구하기
 * 한번에 한계단, 두계단씩 오르기 가능, 세개씩은 불가능, 마지막 도착 계단은 무조건 밟아야함
 * 세칸 뛰어넘기 불가능, 연속하여 3개 밟기도 불가능
 * 첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        dp[0] = arr[0] = 0;

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = arr[1];

        if (N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        }

        System.out.println(dp[N]);
    }
}