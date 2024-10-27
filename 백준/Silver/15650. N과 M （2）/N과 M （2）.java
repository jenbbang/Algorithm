import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder result = new StringBuilder();
    static int[] selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        selected = new int[M];
        visited = new boolean[N + 1];
        
        combination(N, M, 0, 1);
        System.out.print(result);
    }

    static void combination(int N, int M, int depth, int start) {
        if (depth == M) {
            for (int num : selected) {
                result.append(num).append(" ");
            }
            result.append("\n");
            return;
        }
        
        for (int i = start; i <= N; i++) {
            selected[depth] = i;
            combination(N, M, depth + 1, i + 1);
        }
    }
}
