import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int[] rank = new int[N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        for (int i = 0; i < N; i++) {
            rank[i] = 1; // 초기 등수는 1로 설정
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                        rank[i]++;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(rank[i] + " ");
        }
    }
}
