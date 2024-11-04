import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    static int N, M;
    static int[] numbers, selected;
    static Set<String> resultSet = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        numbers = new int[N];
        selected = new int[M];

        // 입력 처리 및 중복 제거
        String[] numStrings = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(numStrings[i]);
        }
        
        // 정렬
        Arrays.sort(numbers);
        
        // 조합 생성
        backtrack(0, 0);
        
        // 결과 출력
        for (String result : resultSet) {
            System.out.println(result);
        }
    }

    static void backtrack(int depth, int start) {
        // 선택한 수가 M개가 되면 결과 저장
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            resultSet.add(sb.toString().trim());
            return;
        }

        for (int i = start; i < N; i++) {
            selected[depth] = numbers[i];
            backtrack(depth + 1, i); // 중복을 허용하기 위해 i를 그대로 유지
        }
    }
}
