import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] tree;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        tree = new ArrayList[n + 1];
        parent = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        // DFS를 통해 부모 노드 찾기
        dfs(1, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int node, int par) {
        parent[node] = par;
        for (int next : tree[node]) {
            if (next != par) {
                dfs(next, node);
            }
        }
    }
}
