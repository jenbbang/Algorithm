import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] selected;
    static boolean[] visited;
    static List<String> resultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N];
        selected = new int[M];
        visited = new boolean[N];

        String[] arrInput = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(arrInput[i]);
        }

        Arrays.sort(arr);
        backtrack(0);
        
        // 결과 출력
        for (String result : resultList) {
            System.out.println(result);
        }
    }

    static void backtrack(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            resultList.add(sb.toString().trim());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue; // 이미 사용된 수는 건너뜀
            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue; // 중복 건너뛰기

            visited[i] = true;
            selected[depth] = arr[i];
            backtrack(depth + 1);
            visited[i] = false;
        }
    }
}
