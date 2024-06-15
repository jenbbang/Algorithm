import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // 테스트 케이스의 수 입력

        for (int i = 0; i < t; i++) {
            int k = sc.nextInt(); // 층 수 입력
            int n = sc.nextInt(); // 호 수 입력

            // 아파트 배열 초기화
            int[][] apt = new int[k + 1][n + 1];

            // 0층 초기화 (각 호수에는 호수만큼의 사람이 산다)
            for (int j = 1; j <= n; j++) {
                apt[0][j] = j;
            }
            // 각 층의 사람 수 계산
            for (int x = 1; x <= k; x++) {
                for (int y = 1; y <= n; y++) {
                    apt[x][y] = apt[x - 1][y] + apt[x][y - 1];
                }
            }
            // k층 n호에 사는 사람 수 출력
            System.out.println(apt[k][n]);
        }
    }
}