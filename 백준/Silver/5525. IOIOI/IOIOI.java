import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
목적 : I와 O로만 이루어진 문자열 S와 정수 N이 주어졌을 때, S안에 PN이 몇 군데 포함되어 있는지 구하는것
N+1개의 I와 N개의 O로 이루어져 있으면, I와 O이 교대로 나오는 문자열을 PN
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int cnt = 0; // 연속된 O의 개수
        int find_I = 0; // PN 패턴의 개수

        // 문자열을 순회
        for (int i = 1; i < m - 1; ) {
            // O 다음에 I가 오는 경우
            if (str.charAt(i) == 'O' && str.charAt(i + 1) == 'I') {
                cnt++; // O의 개수 증가

                // O의 개수가 N이 되면
                if (cnt == n) {
                    // PN 패턴 발견
                    if (str.charAt(i - (cnt * 2 - 1)) == 'I') {
                        find_I++; // 패턴 카운트 증가
                    }
                    cnt--; // 다음 O를 건너뛰기 위해 O 개수 감소
                }
                i += 2; // 다음 문자로 두 칸 이동
            } else {
                cnt = 0; // O가 아닌 경우 O 개수 초기화
                i++; // 다음 문자로 이동
            }
        }

        // 결과 출력
        System.out.println(find_I);
    }
}