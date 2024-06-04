import java.io.IOException;
import java.util.Scanner;

/*
dx[0] = 0, dy[0] = 1: 오른쪽으로 이동
dx[1] = 1, dy[1] = 0: 아래로 이동
dx[2] = 1, dy[2] = 1: 오른쪽 아래 대각선으로 이동
dx[3] = -1, dy[3] = 1: 오른쪽 위 대각선으로 이동
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int boardSize = 19;
        int[][] board = new int[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int[] dx = {0, 1, 1, -1};
        int[] dy = {1, 0, 1, 1};

        // 승리 조건 검사
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] != 0) {
                    int player = board[i][j];

                    for (int d = 0; d < 4; d++) {
                        int count = 1;
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        // 돌이 5개 연속되는지 검사
                        while (isValid(nx, ny, boardSize) && board[nx][ny] == player) {
                            count++;
                            nx += dx[d];
                            ny += dy[d];
                        }

                        // 5개가 연속될 경우 시작점을 출력
                        if (count == 5) {
                            // 시작점의 이전 위치가 같은 돌인지 확인하여 6목 방지
                            int prevX = i - dx[d];
                            int prevY = j - dy[d];
                            if (!isValid(prevX, prevY, boardSize) || board[prevX][prevY] != player) {
                                System.out.println(player);
                                System.out.println((i + 1) + " " + (j + 1));
                                return;
                            }
                        }
                    }
                }
            }
        }

        // 승리 조건을 만족하는 돌이 없을 경우
        System.out.println(0);
    }

    // 좌표 유효성 검사 함수
    private static boolean isValid(int x, int y, int size) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
}