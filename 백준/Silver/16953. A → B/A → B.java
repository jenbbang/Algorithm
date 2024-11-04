import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);

        int result = bfs(A, B);
        System.out.println(result);
    }

    static int bfs(long A, long B) {
        Queue<Long> queue = new LinkedList<>();
        queue.add(A);
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long current = queue.poll();

                // A가 B와 같아지면 연산 횟수 출력
                if (current == B) {
                    return steps + 1; // 현재 단계에서 B에 도달했으므로 +1
                }

                // 두 가지 연산 수행
                long next1 = current * 2; // A에 2를 곱하기
                long next2 = current * 10 + 1; // A에 1을 추가하기

                // 다음 값이 B보다 작거나 같을 때만 큐에 추가
                if (next1 <= B) {
                    queue.add(next1);
                }
                if (next2 <= B) {
                    queue.add(next2);
                }
            }
            steps++; // 단계 증가
        }

        return -1; // B에 도달할 수 없는 경우
    }
}
