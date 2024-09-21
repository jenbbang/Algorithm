import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int white = 0;  // 하얀색 종이의 개수
    static int blue = 0;   // 파란색 종이의 개수

    // 주어진 영역이 같은 색인지 확인하는 함수
    public static boolean isSameColor(int[][] paper, int x, int y, int size) {
        int color = paper[x][y]; // 시작 위치의 색상

        // 영역 전체가 동일한 색인지 확인
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    return false; // 다른 색이 있으면 false
                }
            }
        }
        return true; // 모두 같은 색이면 true
    }

    // 분할 정복 함수
    public static void countPaper(int[][] paper, int x, int y, int size) {
        if (isSameColor(paper, x, y, size)) {
            // 같은 색이면 해당 색의 카운트를 증가시킴
            if (paper[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
        } else {
            // 크기를 반으로 줄여서 4개의 구역으로 나누어 재귀 호출
            int newSize = size / 2;
            countPaper(paper, x, y, newSize);               // 1사분면
            countPaper(paper, x + newSize, y, newSize);      // 2사분면
            countPaper(paper, x, y + newSize, newSize);      // 3사분면
            countPaper(paper, x + newSize, y + newSize, newSize); // 4사분면
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N 입력
        int[][] paper = new int[N][N];

        // 색종이 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 분할 정복 시작
        countPaper(paper, 0, 0, N);

        // 색종이 개수 출력
        System.out.println(white);
        System.out.println(blue);
    }
}
