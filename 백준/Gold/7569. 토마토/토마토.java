import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); // 가로
        int n = Integer.parseInt(st.nextToken()); // 세로
        int h = Integer.parseInt(st.nextToken()); // 높이

        int[][][] box = new int[h][n][m];
        Queue<int[]> queue = new LinkedList<>();
        int totalTomatoes = 0;
        int ripeTomatoes = 0;

        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < m; x++) {
                    box[z][y][x] = Integer.parseInt(st.nextToken());
                    if (box[z][y][x] == 1) {
                        queue.add(new int[]{z, y, x});
                        ripeTomatoes++;
                    }
                    if (box[z][y][x] != -1) {
                        totalTomatoes++; // 익지 않은 토마토 포함
                    }
                }
            }
        }

        int days = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int d = 0; d < 6; d++) {
                    int nz = current[0] + dz[d];
                    int ny = current[1] + dy[d];
                    int nx = current[2] + dx[d];

                    if (nz >= 0 && ny >= 0 && nx >= 0 && nz < h && ny < n && nx < m && box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = 1; // 익게 만들기
                        queue.add(new int[]{nz, ny, nx});
                        ripeTomatoes++;
                    }
                }
            }
            if (!queue.isEmpty()) {
                days++;
            }
        }

        if (ripeTomatoes == totalTomatoes) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }
}
