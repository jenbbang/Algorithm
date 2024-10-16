import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] box;
    static boolean[][] visited;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]); // 가로
        N = Integer.parseInt(input[1]); // 세로

        box = new int[N][M];
        visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(input[j]);
                if (box[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int days = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] dir : directions) {
                    int newX = current[0] + dir[0];
                    int newY = current[1] + dir[1];
                    if (newX >= 0 && newX < N && newY >= 0 && newY < M && box[newX][newY] == 0) {
                        box[newX][newY] = 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            days++;
        }

        // 모든 토마토가 익었는지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(days - 1);
    }
}