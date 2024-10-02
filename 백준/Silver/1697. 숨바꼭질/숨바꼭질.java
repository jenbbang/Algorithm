import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if (n >= m) {
            // 수빈이가 동생의 위치보다 앞에 있거나 같다면, 뒤로 한 칸씩 가는 것이 최단 시간
            System.out.println(n - m);
            return;
        }

        // 방문한 위치를 추적하기 위한 배열
        boolean[] visited = new boolean[100001];
        // 각 위치에 도달하는 데 걸리는 시간을 저장하는 배열
        int[] time = new int[100001];

        // BFS를 위한 큐 초기화
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            // 현재 위치를 큐에서 꺼냄
            int current = queue.poll();

            // 세 가지 가능한 이동 방법 체크
            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) {
                // 다음 위치가 유효하고 아직 방문하지 않았다면
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    time[next] = time[current] + 1;

                    // 동생의 위치에 도달하면 시간을 출력하고 종료
                    if (next == m) {
                        System.out.println(time[next]);
                        return;
                    }
                }
            }
        }

    }
}
