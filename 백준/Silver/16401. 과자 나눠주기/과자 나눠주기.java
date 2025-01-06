import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]); // 조카의 수
        int N = Integer.parseInt(input[1]); // 과자의 수
        
        long[] cookies = new long[N];
        String[] cookieLengths = br.readLine().split(" ");
        
        // 과자의 길이 입력
        for (int i = 0; i < N; i++) {
            cookies[i] = Long.parseLong(cookieLengths[i]);
        }
        
        // 이분 탐색을 위한 변수 설정
        long left = 1; // 최소 길이
        long right = 1000000000; // 최대 길이 (과자의 최대 길이)
        long result = 0; // 결과 저장 변수

        // 최대 막대 과자 길이 찾기
        while (left <= right) {
            long mid = (left + right) / 2; // 중간 길이
            
            // 조카 수에 맞게 막대 과자를 나눌 수 있는지 확인
            if (canDistribute(cookies, mid, M)) {
                result = mid; // 나눌 수 있다면 결과에 저장
                left = mid + 1; // 길이를 늘림
            } else {
                right = mid - 1; // 길이를 줄임
            }
        }
        
        System.out.println(result); // 최대 막대 과자 길이 출력
    }

    // 주어진 길이로 막대 과자를 나눌 수 있는지 확인하는 메서드
    private static boolean canDistribute(long[] cookies, long length, int students) {
        long count = 0;
        for (long cookie : cookies) {
            count += cookie / length; // 해당 길이로 나눌 수 있는 조각 개수
        }
        return count >= students; // 조카 수 이상으로 나눌 수 있는지 체크
    }
}
