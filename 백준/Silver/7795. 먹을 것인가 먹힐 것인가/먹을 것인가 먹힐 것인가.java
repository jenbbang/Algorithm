import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // A 개수
            int M = Integer.parseInt(st.nextToken()); // B 개수

            int[] A = new int[N];
            int[] B = new int[M];

            // A 크기 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            // B 크기 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            // A, B 배열 오름차순 정렬
            Arrays.sort(A);
            Arrays.sort(B);

            int total = 0; // 총 개수
            int bCount = 0; // B 배열의 포인터

            // A의 각 원소에 대해 B의 원소를 비교
            for (int j = 0; j < N; j++) {
                // A[j]보다 작은 B의 원소 개수 세기
                while (bCount < M && B[bCount] < A[j]) {
                    bCount++;
                }
                total += bCount; // A[j]보다 작은 B의 원소의 개수
            }

            System.out.println(total);
        }
    }
}
