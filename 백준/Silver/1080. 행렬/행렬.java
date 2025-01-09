import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        int[][] A = new int[n][m];
        int[][] B = new int[n][m];
        
        // 행렬 A 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                A[i][j] = line.charAt(j) - '0';
            }
        }
        
        // 행렬 B 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                B[i][j] = line.charAt(j) - '0';
            }
        }
        
        int count = 0;
        
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (A[i][j] != B[i][j]) {
                    count++;
                    // 3x3 변환
                    for (int x = 0; x < 3; x++) {
                        for (int y = 0; y < 3; y++) {
                            A[i + x][j + y] ^= 1; // 0과 1을 반전
                        }
                    }
                }
            }
        }
        
        // 변환 후 확인
        boolean isPossible = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] != B[i][j]) {
                    isPossible = false;
                    break;
                }
            }
            if (!isPossible) break;
        }
        
        System.out.println(isPossible ? count : -1);
    }
}
