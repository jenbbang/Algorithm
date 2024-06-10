import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private ArrayList<ArrayList<Integer>> graph;
    private int[] visited;
    private int order;

    public Main(int numOfNodes) {
        graph = new ArrayList<>();
        for (int i = 0; i <= numOfNodes; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new int[numOfNodes + 1];
        order = 1;
    }

    public void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public void sortGraph() {
        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }
    }

    public void dfs(int start) {
        visited[start] = order++;
        for (int neighbor : graph.get(start)) {
            if (visited[neighbor] == 0) {
                dfs(neighbor);
            }
        }
    }

    public void printVisitedOrder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수
        int r = Integer.parseInt(st.nextToken()); // 시작 노드

        Main dfs = new Main(n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            dfs.addEdge(u, v);
        }

        dfs.sortGraph();
        dfs.dfs(r);
        dfs.printVisitedOrder();
    }
}
