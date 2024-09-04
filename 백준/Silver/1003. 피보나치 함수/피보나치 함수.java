import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 개수를 입력 받음
        int T = Integer.parseInt(reader.readLine());

        // 결과를 저장할 배열
        int[] resultsZero = new int[41];
        int[] resultsOne = new int[41];

        // 초기 피보나치 수들의 호출 횟수 설정
        resultsZero[0] = 1;
        resultsZero[1] = 0;
        resultsOne[0] = 0;
        resultsOne[1] = 1;

        // 피보나치 수에 대한 호출 횟수 미리 계산
        for (int i = 2; i <= 40; i++) {
            resultsZero[i] = resultsZero[i - 1] + resultsZero[i - 2];
            resultsOne[i] = resultsOne[i - 1] + resultsOne[i - 2];
        }

        // 각 테스트 케이스에 대해 입력과 출력 처리
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(reader.readLine());
            output.append(resultsZero[n]).append(" ").append(resultsOne[n]).append("\n");
        }

        // 결과 출력
        System.out.print(output.toString());
    }
}
