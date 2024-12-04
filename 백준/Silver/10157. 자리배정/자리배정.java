import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int C = Integer.parseInt(input[0]); // 열의 수
        int R = Integer.parseInt(input[1]); // 행의 수
        int K = Integer.parseInt(br.readLine()); // K번째 자리
        
        int[][] arr = new int[R][C]; // R x C 배열 생성
        int totalSeats = R * C; // 총 좌석 수
        
        // K가 총 좌석 수보다 크면 -1 출력
        if (K > totalSeats) {
            System.out.println(0);
            return;
        }
        
        int x = 0, y = 0; // 시작 좌표
        int dir = 0; // 방향 (0: 오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽)
        int[] dx = {0, 1, 0, -1}; // x 방향 이동 배열
        int[] dy = {1, 0, -1, 0}; // y 방향 이동 배열
        
        for (int i = 1; i <= K; i++) {
            arr[y][x] = i; // 좌석 번호 배정
            
            if (i == K) {
                System.out.println((x + 1) + " " + (y + 1)); // 1-based 인덱스 출력
                return;
            }
            
            // 다음 좌석으로 이동
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];
            
            // 다음 좌석이 배열 범위를 벗어나거나 이미 차있으면 방향 전환
            if (nextX < 0 || nextX >= C || nextY < 0 || nextY >= R || arr[nextY][nextX] != 0) {
                dir = (dir + 1) % 4; // 방향 전환
                nextX = x + dx[dir];
                nextY = y + dy[dir];
            }
            
            x = nextX; // 좌석 이동
            y = nextY;
        }
        
        br.close();
    }
}
