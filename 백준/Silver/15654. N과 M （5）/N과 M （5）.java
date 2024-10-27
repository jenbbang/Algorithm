import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static StringBuilder result = new StringBuilder();
    static int[] selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        String[] numbers = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }
        
        Arrays.sort(arr); // 오름차순 정렬
        
        selected = new int[M];
        visited = new boolean[N];
        
        permutation(arr, N, M, 0);
        System.out.print(result);
    }

    static void permutation(int[] arr, int N, int M, int depth) {
        if (depth == M) {
            for (int num : selected) {
                result.append(num).append(" ");
            }
            result.append("\n");
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = arr[i];
                permutation(arr, N, M, depth + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }
}
