import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String[][] board = new String[M][N];
        for (int i = 0; i < M; i++) {
            board[i] = br.readLine().split("");
        }

        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i <= M - 8; i++) {
            for (int j = 0; j <= N - 8; j++) {
                int count1 = 0; // 왼쪽 위가 W일때
                int count2 = 0; // 왼쪽 위가 B일때
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        if ((x + y) % 2 == 0) {
                            if (!board[i + x][j + y].equals("W")) count1++;
                            if (!board[i + x][j + y].equals("B")) count2++;
                        } else {
                            if (!board[i + x][j + y].equals("B")) count1++;
                            if (!board[i + x][j + y].equals("W")) count2++;
                        }
                    }
                }
                int Min = Math.min(count1, count2);
                minCount = Math.min(minCount, Min);
            }
        }

        System.out.println(minCount);
    }
}
