import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();// 봉우리 및 활잡이 수
        int[] arr = new int[n];

        // 각 봉우리의 높이
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0; // 최대 처치 수를 저장할 변수

        // 각 활잡이 위치에서 처치할 수 있는 최대 봉우리 수 계산
        for (int i = 0; i < n; i++) {
            int kill = 0; // 현재 활잡이의 처치 수를 저장할 변수
            for (int j = i + 1; j < n; j++) {
                // 현재 활잡이 위치에서 오른쪽으로 높은 봉우리를 처치할 수 있는지 확인
                if (arr[i] > arr[j]) {
                    kill++; // 처치 수 증가
                } else {
                    break; // 더 높은 봉우리가 나오면 반복문 종료
                }
            }
            // 최대 처치 수 갱신
            max = Math.max(max, kill);
        }
        System.out.println(max);
    }
}
