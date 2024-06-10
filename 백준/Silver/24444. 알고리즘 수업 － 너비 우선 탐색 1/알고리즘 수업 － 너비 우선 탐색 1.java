import java.util.*;

public class Main {
    static int order = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드의 수
        int m = sc.nextInt(); // 간선의 수
        int r = sc.nextInt(); // 시작 노드

        // 인접 리스트 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력 받기
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 인접 리스트 정렬 (오름차순 방문을 위해)
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        // 방문 순서를 저장할 배열
        int[] visited = new int[n + 1];

        // BFS 실행
        bfs(graph, r, visited);

        // 결과 출력
        for (int i = 1; i <= n; i++) {
            System.out.println(visited[i]);
        }
    }

    public static void bfs(List<List<Integer>> graph, int start, int[] visitOrder) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];

        queue.add(start);
        visited[start] = true;
        visitOrder[start] = order++;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    visitOrder[neighbor] = order++;
                }
            }
        }
    }
}
