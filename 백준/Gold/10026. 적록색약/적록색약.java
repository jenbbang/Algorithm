import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n; // 격자 크기
    static char[][] map; // 색상 정보를 담고 있는 2D 배열
    static boolean[][] visited; // 방문한 위치를 기록하는 배열
    static int[] dx = {-1, 1, 0, 0}; // 상하 이동
    static int[] dy = {0, 0, -1, 1}; // 좌우 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 격자 크기 입력
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        
        // 격자 색상 입력
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        visited = new boolean[n][n]; // 방문 배열 초기화
        int normalCount = 0; // 일반인 기준 구역 수 카운트

        // 일반인 기준으로 구역 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) { // 방문하지 않은 경우
                    dfs(i, j, map[i][j]); // DFS 호출
                    normalCount++; // 구역 수 증가
                }
            }
        }

        // 적록색약 기준으로 구역 수 카운트 초기화
        visited = new boolean[n][n]; // 방문 배열 초기화
        int colorBlindCount = 0; // 적록색약 기준 구역 수 카운트

        // 적록색약 기준으로 구역 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) { // 방문하지 않은 경우
                    dfsColorBlind(i, j, map[i][j]); // DFS 호출
                    colorBlindCount++; // 구역 수 증가
                }
            }
        }

        // 결과 출력 (일반인 구역 수, 적록색약 구역 수)
        System.out.println(normalCount + " " + colorBlindCount);
    }

    // 일반인 기준 DFS 탐색
    static void dfs(int x, int y, char color) {
        visited[x][y] = true; // 현재 위치 방문 처리
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i]; // 다음 위치 x좌표
            int ny = y + dy[i]; // 다음 위치 y좌표
            // 범위 체크 및 방문 여부, 색상 체크
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] == color) {
                dfs(nx, ny, color); // 재귀 호출
            }
        }
    }

    // 적록색약 기준 DFS 탐색
    static void dfsColorBlind(int x, int y, char color) {
        visited[x][y] = true; // 현재 위치 방문 처리
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i]; // 다음 위치 x좌표
            int ny = y + dy[i]; // 다음 위치 y좌표
            // 범위 체크 및 방문 여부, 색상 체크 (R과 G는 동일시)
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && 
                (map[nx][ny] == color || (color == 'R' && map[nx][ny] == 'G') || (color == 'G' && map[nx][ny] == 'R'))) {
                dfsColorBlind(nx, ny, color); // 재귀 호출
            }
        }
    }
}
