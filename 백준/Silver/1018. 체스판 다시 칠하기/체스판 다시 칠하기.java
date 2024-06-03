import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[][] martrix = new boolean[N + 100][M + 100];

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                martrix[i][j] = (str.charAt(j) == 'W');
            }
        }

        int chessRow = N - 7;
        int chessColumn = M - 7;

        int answer = 64;
        for (int i = 0; i < chessRow; i++) {
            for (int j = 0; j < chessColumn; j++) {
                //최솟갑 구하기
                answer = Math.min(answer, solve(martrix, i, j));
            }

        }
        System.out.println(answer);
    }

    public static int solve(boolean[][] martix, int x, int y) {
        int chessX = x + 8;  // 새로운 좌표
        int chessY = y + 8;
        int count = 0;

        boolean curColor = martix[x][y]; //체스판 첫번재 값

        for (int i = x; i < chessX; i++) {
            for (int j = y; j < chessY; j++) {
                if (martix[i][j] != curColor) {
                    count++;
                }
                curColor = (!curColor);
            }
            curColor = (!curColor);
        }
        return Math.min(count, 64 - count);
    }
}
