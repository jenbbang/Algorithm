import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
첫째 줄 : 전체 사람의 수 n
둘째 줄 : 촌수를 계산해야 하는 서로 다른 두 사람의 번호
셋째 줄 : 부모 자식들 간의 관계의 개수 m
넷째 줄 : 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다.
이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        // 부모-자식 관계를 나타내는 인접 행렬
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1; // a가 b의 부모
            graph[b][a] = 1; // b가 a의 부모
        }

        // x와 y 사이의 촌수를 계산
        int result = bfs(graph, n, x, y);
        System.out.println(result);
    }

    static int bfs(int[][] graph, int n, int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor = 1; neighbor <= n; neighbor++) {
                if (graph[current][neighbor] == 1 && !visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);

                    // 목적지에 도착했을 때
                    if (neighbor == target) {
                        return distance[neighbor];
                    }
                }
            }
        }

        return -1; // 두 사람 간의 관계가 없을 경우
    }
}
