import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 나무의 수
        int M = sc.nextInt(); // 나무의 길이
       int [] trees = new int[N];


       int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = sc.nextInt();
            if (trees[i]> max){
                max = trees[i];
            }
        }
        // 이분 탐색을 위한 변수 설정
        int low = 0;
        int high = max;

        while (low <= high) {
            int mid = (low + high) / 2;
            long wood = 0;

            // 주어진 높이에서 얻을 수 있는 나무의 길이 계산
            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) {
                    wood += trees[i] - mid;
                }
            }

            // 필요한 나무 길이와 비교하여 이분 탐색 범위 조정
            if (wood >= M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(high);
    }
}