import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 받기
        String[] firstLine = reader.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]); // 집의 개수
        int C = Integer.parseInt(firstLine[1]); // 공유기의 개수
        int[] houses = new int[N];
        
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(reader.readLine()); // 각 집의 좌표
        }
        
        // 집의 좌표를 정렬
        Arrays.sort(houses);
        
        // 이진 탐색을 위한 변수 설정
        int left = 1; // 최소 거리
        int right = houses[N - 1] - houses[0]; // 최대 거리
        int result = 0;
        
        // 이진 탐색
        while (left <= right) {
            int mid = (left + right) / 2; // 중간 거리
            if (canPlaceRouters(houses, mid, C)) {
                result = mid; // 가능한 경우, 결과 업데이트
                left = mid + 1; // 더 큰 거리 탐색
            } else {
                right = mid - 1; // 더 작은 거리 탐색
            }
        }
        
        // 결과 출력
        System.out.println(result);
    }
    
    // 공유기를 설치할 수 있는지 확인하는 함수
    private static boolean canPlaceRouters(int[] houses, int distance, int C) {
        int count = 1; // 첫 번째 공유기 설치
        int lastPosition = houses[0]; // 마지막 설치 위치
        
        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - lastPosition >= distance) {
                count++; // 공유기 설치
                lastPosition = houses[i]; // 마지막 설치 위치 업데이트
            }
            if (count >= C) {
                return true; // 필요한 수의 공유기를 설치할 수 있음
            }
        }
        
        return false; // 설치할 수 없음
    }
}
