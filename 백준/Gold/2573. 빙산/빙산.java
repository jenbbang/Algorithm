import java.io.*;
import java.util.*;

public class Main {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int M = fr.nextInt();
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = fr.nextInt();
            }
        }

        int ans = 0;
        Queue<int[]> Q = new LinkedList<>();

        while (!isNoIce(arr)) {
            if (!findIceMountain(Q, arr)) {
                ans = 0;
                break;
            }
            ans++;
            meltIce(Q, arr);
            if (moreThanTwo(arr, new boolean[N][M])) break;
        }

        System.out.println(ans);
    }

    public boolean isNoIce(int[][] a) {
        for (int[] row : a) {
            for (int cell : row) {
                if (cell == 0) return false;
            }
        }
        return true;
    }

    public boolean findIceMountain(Queue<int[]> Q, int[][] m) {
        Q.clear();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] > 0) {
                    int zeroVal = countAdjacentWater(m, i, j);
                    Q.offer(new int[]{i, j, zeroVal});
                }
            }
        }
        return !Q.isEmpty();
    }

    private int countAdjacentWater(int[][] m, int x, int y) {
        int zeroVal = 0;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && ny >= 0 && nx < m.length && ny < m[0].length && m[nx][ny] == 0) {
                zeroVal++;
            }
        }
        return zeroVal;
    }

    public void meltIce(Queue<int[]> Q, int[][] arr) {
        while (!Q.isEmpty()) {
            int[] c = Q.poll();
            arr[c[0]][c[1]] = Math.max(arr[c[0]][c[1]] - c[2], 0);
        }
    }

    public boolean moreThanTwo(int[][] m, boolean[][] v) {
        int cnt = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] > 0 && !v[i][j]) {
                    if (cnt > 0) return true;
                    cnt++;
                    v[i][j] = true;
                    dfs(m, i, j, v);
                }
            }
        }
        return false;
    }

    public void dfs(int[][] m, int x, int y, boolean[][] v) {
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && ny >= 0 && nx < m.length && ny < m[0].length && m[nx][ny] > 0 && !v[nx][ny]) {
                v[nx][ny] = true;
                dfs(m, nx, ny, v);
            }
        }
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
