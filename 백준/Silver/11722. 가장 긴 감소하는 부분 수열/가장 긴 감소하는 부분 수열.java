import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 수열의 크기 N을 입력 받음
        int[] a = new int[n]; // 수열 A를 저장할 배열
        int[] dp = new int[n]; // 각 위치에서의 가장 긴 감소하는 부분 수열의 길이를 저장할 배열

        // 수열 A를 입력 받음
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int maxLength = 1; // 가장 긴 감소하는 부분 수열의 길이를 저장할 변수
        // DP 배열 초기화 및 가장 긴 감소하는 부분 수열 찾기
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 최소 길이는 자기 자신만 포함할 때 1
            for (int j = 0; j < i; j++) {
                if (a[j] > a[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxLength = Math.max(maxLength, dp[i]); // 가장 긴 길이 갱신
        }

        System.out.println(maxLength); // 결과 출력
    }
}
