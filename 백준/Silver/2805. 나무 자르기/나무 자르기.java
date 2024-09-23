import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 필요한 나무의 길이

        int[] trees = new int[N];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max) {
                max = trees[i];
            }
        }

        int low = 0;
        int high = max;

        // 이분 탐색 시작
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
