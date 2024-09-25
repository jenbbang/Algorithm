import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    // DFS 함수: 정점 v에서 시작하여 연결된 모든 정점을 방문
    public static void dfs(int v) {
        visited[v] = true; // 현재 정점 방문 처리

        // 현재 정점과 연결된 다른 정점들을 탐색
        for (int i : graph.get(v)) {
            if (!visited[i]) {
                dfs(i); // 방문하지 않은 정점에 대해 DFS 재귀 호출
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수

        // 그래프 초기화: n개의 정점을 위한 인접 리스트 생성
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v); // 정점 u에서 정점 v로의 간선 추가
            graph.get(v).add(u); // 무향 그래프이므로 정점 v에서 정점 u로의 간선도 추가
        }

        // 방문 여부를 저장할 배열 초기화
        visited = new boolean[n + 1];
        int connectedComponents = 0; // 연결 요소 개수

        // 모든 정점을 탐색하며 연결 요소를 찾음
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) { // 아직 방문하지 않은 정점이 있다면
                dfs(i); // DFS 탐색 시작
                connectedComponents++; // 새로운 연결 요소 발견
            }
        }

        // 결과 출력: 연결 요소의 개수
        System.out.println(connectedComponents);
    }
}
