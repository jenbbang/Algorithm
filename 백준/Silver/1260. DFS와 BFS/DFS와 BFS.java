import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] treeArray;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 정점 개수
        int M = Integer.parseInt(st.nextToken());   // 간선 개수
        int V = Integer.parseInt(st.nextToken());   // 시작 정점 번호

        treeArray = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 연결된 노드를 1로 세팅
            treeArray[a][b] = 1;
            treeArray[b][a] = 1;
        }

        // node가 1부터 시작하기 때문에 N + 1
        visited = new boolean[N + 1];
        dfs(V);

        System.out.println();

        visited = new boolean[N + 1];

        bfs(V);

        System.out.println();
    }

    private static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        if (v == treeArray.length) return;

        for (int j = 1; j < treeArray.length; j++) {
            // 연결된 노드인데 방문하지 않은 경우
            if (treeArray[v][j] == 1 && visited[j] == false) {
                // 연결된 노드 찾으면 재귀함수 호출
                dfs(j);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(v);
        visited[v] = true;

        System.out.print(v + " ");

        while (!queue.isEmpty()) {
            int n = queue.poll();

            // 노드 하나로 연결된 노드 먼저 다 체크
            for (int i = 1; i < treeArray.length; i++) {
                // 연결된 노드인데 방문하지 않은 경우
                if (treeArray[n][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    System.out.print(i + " ");
                    queue.offer(i);
                }
            }
        }
    }
}
