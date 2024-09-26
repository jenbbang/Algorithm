import java.io.*;
import java.util.*;

/*
목적 : 이 집터 내의 땅의 높이를 일정하게 바꾸는 것

할 수 있는 작업
1. 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다.
2. 인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다.

작업시간
1번 작업 -> 2초
2번 작업 -> 1초

주의점
1. 밤에는 작업x
2. 집터 아에 공간 존재 x
3. 집터바깥에서 블록 가져오기 x
4. 작업 시작 시 인벤토리에는 B개의, 블록이 있다
5. 땅 높이는 256 블록 초과 x, 음수 x

입력
1. 첫째 줄에 N, M, B가 주어진다. (1 ≤ M, N ≤ 500, 0 ≤ B ≤ 6.4 × 107)
2. 둘째 줄부터 N개의 줄에 각각 M개의 정수로 땅의 높이가 주어진다.
3. (i + 2)번째 줄의 (j + 1)번째 수는 좌표 (i, j)에서의 땅의 높이를 나타낸다.
4. 땅의 높이는 256보다 작거나 같은 자연수 또는 0이다.

출력
1. 첫째 줄에 땅을 고르는 데 걸리는 시간과 땅의 높이를 출력
2. 답이 여러 개 있다면 그중에서 땅의 높이가 가장 높은 것을 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 세로 길이
        int m = Integer.parseInt(st.nextToken());  // 가로 길이
        int b = Integer.parseInt(st.nextToken());  // 인벤토리에 있는 블록 수

        int[][] land = new int[n][m];  // 땅의 높이 배열
        int maxHeight = 0, minHeight = 256;

        // 땅의 높이 입력 및 최대, 최소 높이 확인
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                if (land[i][j] > maxHeight) maxHeight = land[i][j];
                if (land[i][j] < minHeight) minHeight = land[i][j];
            }
        }
        int resultTime = Integer.MAX_VALUE;  // 최소 시간
        int resultHeight = -1;  // 결과 높이

        // 가능한 모든 높이(최소 ~ 최대) 탐색
        for (int h = minHeight; h <= maxHeight; h++) {
            int removeBlocks = 0;
            int addBlocks = 0;

            // 각 좌표에서 현재 높이 h로 만들기 위해 필요한 블록 계산
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (land[i][j] > h) {
                        // 블록 제거 (높이가 더 높을 경우)
                        removeBlocks += (land[i][j] - h);
                    } else {
                        // 블록 추가 (높이가 더 낮을 경우)
                        addBlocks += (h - land[i][j]);
                    }
                }
            }
            // 인벤토리의 블록 수로 땅을 평평하게 만들 수 있는지 확인
            if (removeBlocks + b >= addBlocks) {
                // 총 시간 계산 (블록 제거는 2초, 추가는 1초)
                int time = removeBlocks * 2 + addBlocks;

                // 최소 시간이면 갱신, 높이가 같을 경우 더 높은 땅 선택
                if (time <= resultTime) {
                    resultTime = time;
                    resultHeight = h;
                }
            }
        }
        System.out.println(resultTime + " " + resultHeight);
    }
}