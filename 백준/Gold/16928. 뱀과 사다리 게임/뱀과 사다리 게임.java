import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N, M, res; // 사다리와 뱀의 개수, 이동 횟수
    static int start = 1, end = 100; // 시작과 끝 위치
    static boolean[] visited; // 방문 체크
    static Map<Integer, Integer> gameThings; // 뱀과 사다리 맵

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 사다리와 뱀의 개수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[101]; // 1부터 100까지 방문 체크
        gameThings = new HashMap<>(); // 사다리와 뱀 저장

        // 사다리 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            gameThings.put(x, y); // 사다리 추가
        }

        // 뱀 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            gameThings.put(x, y); // 뱀 추가
        }

        bfs(); // BFS 탐색
        bw.write(res + "\n"); // 결과 출력
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true; // 시작 위치 방문 처리

        while (!q.isEmpty()) {
            int qSize = q.size();
            res++; // 이동 횟수 증가

            for (int i = 0; i < qSize; i++) {
                int now = q.poll(); // 현재 위치

                // 주사위 던지기
                for (int j = 1; j <= 6; j++) {
                    int move = now + j; // 이동할 칸 계산
                    if (move == end) return; // 100에 도착하면 종료

                    if (move > end) continue; // 100을 초과하면 무시
                    if (visited[move]) continue; // 이미 방문한 칸이면 무시

                    visited[move] = true; // 방문 처리

                    // 사다리나 뱀을 만나는 경우
                    if (gameThings.containsKey(move)) {
                        move = gameThings.get(move);
                    }

                    q.add(move); // 다음 위치 큐에 추가
                }
            }
        } // end of while
    }
}
