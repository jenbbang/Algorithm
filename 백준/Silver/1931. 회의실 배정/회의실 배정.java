import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2]; // 회의 시작 시간과 끝나는 시간을 저장할 배열
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            arr[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간
        }

        // 회의 끝나는 시간을 기준으로 정렬. 끝나는 시간이 같으면 시작 시간을 기준으로 정렬
        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]); // 끝나는 시간이 같으면 시작 시간으로 정렬
            }
            return Integer.compare(a[1], b[1]); // 끝나는 시간 기준 정렬
        });

        int answer = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            // 이전 회의가 끝난 시간(end)보다 현재 회의의 시작 시간이 같거나 늦으면 회의를 할 수 있다
            if (arr[i][0] >= end) {
                end = arr[i][1]; // 현재 회의의 끝나는 시간으로 갱신
                answer++; // 회의 개수를 하나 증가
            }
        }

        System.out.println(answer); // 최대로 배정할 수 있는 회의의 수 출력
    }
}
