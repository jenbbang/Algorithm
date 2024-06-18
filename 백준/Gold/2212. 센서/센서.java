import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 센서의 개수
        int k = sc.nextInt();  // 집중국의 개수

        // 센서 좌표 배열 초기화
        int[] sensors = new int[n];

        // 센서 좌표 입력 받기
        for (int i = 0; i < n; i++) {
            sensors[i] = sc.nextInt();
        }

        // 센서 좌표 오름차순으로 정렬
        Arrays.sort(sensors);

        // 인접한 센서들 간의 거리 계산
        int[] distances = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            distances[i] = sensors[i + 1] - sensors[i];
        }

        // 거리를 오름차순으로 정렬
        Arrays.sort(distances);

        // 가장 긴 K-1개의 거리 합을 계산
        int sum = 0;
        for (int i = 0; i < n - k; i++) {
            sum += distances[i];
        }

        // 결과 출력
        System.out.println(sum);
    }
}
