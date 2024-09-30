import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // 상, 하, 좌, 우로 이동하기 위한 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // BFS 탐색 함수
    public static int bfs(char[][] campus, boolean[][] visited, int startX, int startY, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int peopleCount = 0; // 만난 사람의 수

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 상, 하, 좌, 우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위를 벗어나지 않고, 아직 방문하지 않았으며, 벽이 아닌 경우
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && campus[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});

                    if (campus[nx][ny] == 'P') {
                        peopleCount++; // 사람을 만나면 카운트 증가
                    }
                }
            }
        }

        return peopleCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 캠퍼스 크기 입력
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); // 개행 처리

        char[][] campus = new char[n][m];
        boolean[][] visited = new boolean[n][m];

        int startX = 0, startY = 0;

        // 캠퍼스 상태 입력
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                campus[i][j] = line.charAt(j);
                if (campus[i][j] == 'I') {
                    startX = i; // 도연이의 시작 위치 저장
                    startY = j;
                }
            }
        }

        // BFS 탐색 시작
        int result = bfs(campus, visited, startX, startY, n, m);

        if (result > 0) {
            System.out.println(result);
        } else {
            System.out.println("TT");
        }

        sc.close();
    }
}
