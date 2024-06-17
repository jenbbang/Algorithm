import java.util.*;

public class Main {
    static final int INF = 200000000;
    static List<int[]>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        long path1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
        long path2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);

        long result = Math.min(path1, path2);
        System.out.println(result >= INF ? -1 : result);
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[graph.length];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int curNode = current[0];
            int curDist = current[1];

            if (curDist > dist[curNode]) continue;

            for (int[] edge : graph[curNode]) {
                int nextNode = edge[0];
                int weight = edge[1];
                if (dist[nextNode] > dist[curNode] + weight) {
                    dist[nextNode] = dist[curNode] + weight;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        return dist[end];
    }
}
