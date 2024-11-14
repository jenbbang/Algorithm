import java.io.*;
import java.util.*;

public class Main {
    static int N, M; // N: 맵의 크기, M: 선택할 치킨집의 수
    static int[][] map; // 맵을 저장할 배열
    static List<int[]> houses = new ArrayList<>(); // 집의 위치를 저장할 리스트
    static List<int[]> chickens = new ArrayList<>(); // 치킨집의 위치를 저장할 리스트
    static int minDistance = Integer.MAX_VALUE; // 최소 거리 합을 저장할 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 맵의 크기 N 입력
        M = Integer.parseInt(st.nextToken()); // 선택할 치킨집의 수 M 입력
        map = new int[N][N]; // N x N 크기의 맵 초기화

        // 맵 입력 및 집, 치킨집 위치 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    houses.add(new int[]{i, j}); // 집 위치 저장
                } else if (map[i][j] == 2) {
                    chickens.add(new int[]{i, j}); // 치킨집 위치 저장
                }
            }
        }

        // 치킨집 선택 조합 생성 시작
        chooseChicken(0, 0, new int[M][2]);
        // 최소 거리 합 출력
        System.out.println(minDistance);
    }

    // 치킨집을 선택하는 메소드
    static void chooseChicken(int idx, int count, int[][] selected) {
        if (count == M) { // 선택한 치킨집의 수가 M과 같으면
            calculateDistance(selected); // 거리 계산
            return;
        }

        // 조합 생성
        for (int i = idx; i < chickens.size(); i++) {
            selected[count] = chickens.get(i); // 현재 치킨집 선택
            chooseChicken(i + 1, count + 1, selected); // 다음 치킨집 선택
        }
    }

    // 선택된 치킨집에 대한 거리 계산 메소드
    static void calculateDistance(int[][] selected) {
        int totalDistance = 0; // 총 거리 초기화

        // 각 집에 대해
        for (int[] house : houses) {
            int minDist = Integer.MAX_VALUE; // 집과 치킨집 간의 최소 거리 초기화

            // 선택된 치킨집에 대해 거리 계산
            for (int[] chicken : selected) {
                int dist = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]); // 맨해튼 거리 계산
                minDist = Math.min(minDist, dist); // 최소 거리 업데이트
            }

            totalDistance += minDist; // 총 거리 합산
        }

        minDistance = Math.min(minDistance, totalDistance); // 최소 거리 업데이트
    }
}
