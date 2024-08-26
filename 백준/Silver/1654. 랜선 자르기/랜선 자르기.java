import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
        int n = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        long[] arr = new long[k];

        for (int i = 0; i < k; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        long maxLength = 0;
        for (long length : arr) {
            if (length > maxLength) {
                maxLength = length; // 가장 긴 랜선의 길이를 찾음
            }
        }

        long minLength = 1;  // 랜선의 최소 길이 설정
        long optimalLength = 0;

        // 이분 탐색을 이용해 랜선의 최대 길이를 구함
        while (minLength <= maxLength) {
            long mid = (minLength + maxLength) / 2;  // 중간값 계산
            long count = 0; // mid 길이로 자른 랜선의 총 개수

            // 각 랜선을 mid 길이로 자를 때 얻을 수 있는 랜선의 총 개수를 계산
            for (long length : arr) {
                count += (length / mid);
            }

            if (count >= n) {  // 얻은 랜선의 개수가 N 이상이면
                optimalLength = mid;  // 가능한 최대 길이를 저장
                minLength = mid + 1;  // 더 긴 길이로 자를 수 있는지 확인하기 위해 minLength 증가
            } else {  // 얻은 랜선의 개수가 N 미만이면
                maxLength = mid - 1;  // 더 짧은 길이로 자르기 위해 maxLength 감소
            }
        }

        System.out.println(optimalLength);  // 최종적으로 얻어진 optimalLength 출력
    }
}
