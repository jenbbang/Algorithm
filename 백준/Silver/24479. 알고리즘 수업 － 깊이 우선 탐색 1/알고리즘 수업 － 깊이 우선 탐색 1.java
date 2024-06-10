import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int order = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();

        // 인접 리스트 초기화
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] visited = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 각 리스트를 오름차순으로 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(graph, visited, r);

        for (int i = 1; i <= n; i++) {
            System.out.println(visited[i]);
        }
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int[] visited, int start) {
        visited[start] = order++;
        for (int neighbor : graph.get(start)) {
            if (visited[neighbor] == 0) {
                dfs(graph, visited, neighbor);
            }
        }
    }
}
